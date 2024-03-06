// Download the Node helper library from twilio.com/docs/node/install
// These consts are your accountSid and authToken from https://www.twilio.com/console
// To set up environmental variables, see http://twil.io/secure
const accountSid = process.env.TWILIO_ACCOUNT_SID;
const authToken = process.env.TWILIO_AUTH_TOKEN;

const client = require('twilio')(accountSid, authToken);

const filterOpts = {
  to: 'to_number',
  from: 'from_number',
  dateSent: new Date(2016, 0, 1),
};

client.messages.each(filterOpts, message => console.log(message.body));
