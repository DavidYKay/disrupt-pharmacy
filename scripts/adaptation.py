from mail import Email

if __name__ == '__main__':
    mail = Email(to='testpatient@gargoyle.co', subject='Adaptation Complete')
    ctx = {'username': 'Joe Schmoe'}
    mail.text('adaptation.txt', ctx)
    mail.html('adaptation.html', ctx)  # Optional
    mail.send()

