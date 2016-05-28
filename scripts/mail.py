import boto.ses
from jinja2 import Environment, PackageLoader
from credentials import AWS_ACCESS_KEY, AWS_SECRET_KEY

# Loads templates from the followup.templates folder
env = Environment(loader=PackageLoader('followup', 'templates'))

class Email(object):
    def __init__(self, to, subject):
        self.to = to
        self.subject = subject
        self._html = None
        self._text = None

    def _render(self, filename, context):
        template = env.get_template(filename)
        return template.render(context)

    def html(self, filename, context):
        self._html = self._render(filename, context)

    def text(self, filename, context):
        self._text = self._render(filename, context)

    def send(self, from_addr=None):
        body = self._html

        if isinstance(self.to, basestring):
            self.to = [self.to]
        if not from_addr:
            from_addr = 'disruptpharmacy@gargoyle.co'
        if not self._html and not self._text:
            raise Exception('You must provide a text or html body.')
        #if not self._html:
        #    self._format = 'text'
        #    body = self._text

        connection = boto.ses.connect_to_region(
            'us-west-2',
            aws_access_key_id=AWS_ACCESS_KEY,
            aws_secret_access_key=AWS_SECRET_KEY
        )

        return connection.send_email(
            from_addr,
            self.subject,
            None,
            self.to,
            format='html',
            text_body=self._text,
            html_body=self._html
        )
