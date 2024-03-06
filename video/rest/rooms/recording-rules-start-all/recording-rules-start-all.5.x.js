// Download the helper library from https://www.twilio.com/docs/node/install
// Your Account Sid and Auth Token from twilio.com/console
// and set the environment variables. See http://twil.io/secure
const accountSid = process.env.TWILIO_ACCOUNT_SID;
const authToken = process.env.TWILIO_AUTH_TOKEN;
const client = require('twilio')(accountSid, authToken);

client.video.rooms('RMXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX')
            .recordingRules
            .update({rules: [{"type": "include", "all": true}]})
            .then(recording_rules => console.log(recording_rules.roomSid));
