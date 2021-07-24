module.exports = {
    name: 'napad',
    aliases: [],
    category: 'tickets',
    utilisation: '{prefix}napad',

    execute(client, message) {
	const msg = message
        if(msg.channel.topic == "commands" ) {
        msg.delete()
        if(!(msg.member.roles.cache.has('821121148343418971'))) {
          msg.member.roles.add('821121148343418971')
        const embed = {
            "title": "✅ | TICKET VYTVOŘEN!",
            "description": "Tvůj ticket byl vytvořen!",
            "color": 8311585
          };
          msg.channel.send({ embed }).then(msg => msg.delete({timeout: 5000}))
        msg.guild.channels.create('ticket-' +msg.member.user.username, {
            type: 'text',
            permissionOverwrites: [
                {
                    id: msg.guild.roles.cache.get("760137333273133126"),
                    deny: ["VIEW_CHANNEL", "SEND_MESSAGES"]
                },
                {
                  id: msg.member.id,
                  allow: ["VIEW_CHANNEL", "SEND_MESSAGES"]
                },
                {
                  id: msg.guild.roles.cache.get("784922662790758451"),
                  allow: ["VIEW_CHANNEL", "SEND_MESSAGES"]
                },
                {
                  id: msg.guild.roles.cache.get("784923891109855242"),
                  allow: ["VIEW_CHANNEL", "SEND_MESSAGES"]
                }
            ],
            
          }).then(channel => channel.setTopic("ticket")).then(channel =>
            {
                if(msg.member.user.avatarURL == null) {
                    const embed = {
                        "title": "📝 | Vítej ve tvém ticketu, " +msg.member.user.username + "!",
                        "description": "Teď už máš ticket vytvořený, přichází ta těžší část.. popiš nám tvůj problém. Zachvilku se ti někdo z AT bude věnovat!",
                        "color": 16312092,
                        "footer": {
                          "text": msg.member.user.username
                        }
                      };   
                      channel.send({ embed })
                } else {
                const embed = {
                "title": "📝 | Vítej ve tvém ticketu, " +msg.member.user.username + "!",
                "description": "Teď už máš ticket vytvořený, přichází ta těžší část.. popiš nám tvůj problém. Zachvilku se ti někdo z AT bude věnovat!",
                "color": 16312092,
                "footer": {
                  "icon_url": msg.member.user.avatarURL,
                  "text": msg.member.user.username
                }
              };
              channel.send({ embed })
            }
        })
      } else {
          const embed = {
            "title": "❌ | ERROR!",
            "description": "Již máš vytvořený jeden ticket!",
            "color": 13632027
          };
          msg.delete({timeout: 5000});
          msg.channel.send({ embed }).then(msg => msg.delete({timeout: 5000}))
    }
        } else {
              const embed = {
                "title": "❌ | ERROR!",
                "description": "Tento příkaz můžeš použít pouze v <#760533014781755453> aby jsi nespamoval/a chat!",
                "color": 13632027
              };
              msg.delete({timeout: 5000});
              msg.channel.send({ embed }).then(msg => msg.delete({timeout: 5000}))
        }
    },
};