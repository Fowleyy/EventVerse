const db = require('quick.db')

module.exports = {
    name: 'shiba',
    aliases: [],
    category: 'fun',
    utilisation: '{prefix}shiba',

    async execute(client, message, args) {
  		let channel = message.channel
  		let member = message.member
  		var Shiba1= message.guild.emojis.cache.find(emoji => emoji.name === 'ShibaCool');
  		var Shiba2 = message.guild.emojis.cache.find(emoji => emoji.name === 'ShibaLol');
 		var Shiba3 = message.guild.emojis.cache.find(emoji => emoji.name === 'ShibaLove');
  		var Shiba4 = message.guild.emojis.cache.find(emoji => emoji.name === 'ShibaInLove');
  		var Shiba5 = message.guild.emojis.cache.find(emoji => emoji.name === 'SshibaSparklyEyes');
  		var Shiba6 = message.guild.emojis.cache.find(emoji => emoji.name === 'ShibaNervous');
  		var Shiba7 = message.guild.emojis.cache.find(emoji => emoji.name === 'ShibaMad');
  		const shibamessage = [`${Shiba1}`, `${Shiba2}`, `${Shiba3}`, `${Shiba4}`, `${Shiba5}`, `${Shiba6}`, `${Shiba7}`]
  		const randomShibaMessage = shibamessage[Math.floor(Math.random() * shibamessage.length)];
    	if(message.channel.id == "786626090050912329") {
      		message.channel.send(randomShibaMessage)
      		db.add(`shibacount`, 1)
			const shibacount = await db.get(`shibacount`)
      		message.channel.send("Shiba count: **" +shibacount +"**" )
    	} else {
      		message.delete( {timeout: 5000} )
      		message.member.send("**[!]** Tento command můžeš použít pouze v kanálu <#786626090050912329>!")
    	}
	}
}