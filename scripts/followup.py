from mail import Email

if __name__ == '__main__':
    mail = Email(to='testpatient@gargoyle.co', subject='Follow-up')
    ctx = {'username': 'Joe Schmoe'}
    mail.text('followup.txt', ctx)
    mail.html('followup.html', ctx)  # Optional
    mail.send()

