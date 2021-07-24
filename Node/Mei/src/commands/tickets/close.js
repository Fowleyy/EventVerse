module.exports = {
    name: 'close',
    aliases: [],
    category: 'tickets',
    utilisation: '{prefix}close <meno>',

    execute(client, message) {
	const msg = message
        if(msg.member.hasPermission("MANAGE_MESSAGES")) {
            if(msg.channel.topic == "ticket") {
                const embed = {
                    "title": "⌛ | ZAVÍRÁM TICKET..",
                    "description": "Uzavírám ticket za **10s**...",
                    "color": 16098851
                  };
                  msg.channel.send({ embed });
				  msg.mentions.members.first().roles.remove('821121148343418971')
                  setTimeout(() => msg.channel.delete(), 15000)
            } else {
                const embed = {
                    "title": "❌ | ERROR!",
                    "description": "Tento příkaz můžeš použít pouze v ticket channelech!",
                    "color": 13632027
                  };
                  msg.delete();
                  msg.member.send({ embed })
            }
        } else {
            const embed = {
                "title": "❌ | ERROR!",
                "description": "Na použití tohoto příkazu nemáš dostatečné práva!",
                "color": 13632027
              };
              msg.delete();
              msg.member.send({ embed })
        }
    }
};