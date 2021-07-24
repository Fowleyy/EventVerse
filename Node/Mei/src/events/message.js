const db = require('quick.db')
const sendmessage = require('../send-message')

module.exports = async (client, message) => {
    if (message.author.bot || message.channel.type === 'dm') return;

	if (message.content.includes("1st") || message.content.includes("**1st**") || message.content.includes("*1st*") || message.content.includes("*1st*")) {
		message.delete()
		sendmessage(client, message.channel.id, `<@!${message.member.id}>, nepodporujeme tu **1st**`, 5);
	}

  	if (message.member.roles.cache.has('760155297405730836')) {
       let test = "test"	
  	} else {
      	message.member.roles.add('760155297405730836') // member
      	message.member.roles.add('760151670968811542') // pings ----
      	message.member.roles.add('760153844075200622') // ozn ping
      	message.member.roles.add('760165732406263888') // giveaway
      	message.member.roles.add('809153761297563679') // sneak peaks
      	message.member.roles.add('800715349296676874') // Odznaky ----
  	}

	let prefix = db.get(`prefix_${message.guild.id}`)
	if (!prefix) prefix = "!";

    if (message.content.indexOf(prefix) !== 0) return;

    const args = message.content.slice(prefix.length).trim().split(/ +/g);
    const command = args.shift().toLowerCase();

    const cmd = client.commands.get(command) || client.commands.find(cmd => cmd.aliases && cmd.aliases.includes(command));

    if (cmd) cmd.execute(client, message, args);
};