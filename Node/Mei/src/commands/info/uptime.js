module.exports = {
    name: 'uptime',
    aliases: [],
    category: 'Infos',
    utilisation: '{prefix}uptime',

    execute(client, message) {
  let seconds = Math.floor(message.client.uptime / 1000);
  let minutes = Math.floor(seconds / 60);
  let hours = Math.floor(minutes / 60);
  let days = Math.floor(hours / 24);
  var SurfarEmoji = message.guild.emojis.cache.find(emoji => emoji.name === 'ZabickaSurfar');

  seconds %= 60;
  minutes %= 60;
  hours %= 24;

  const embed = {
	"color": "ORANGE",
    "description": `**Uptime:**\n\`${days} day(s) ${hours} hours ${minutes} minutes ${seconds} seconds\``,
 //   "color": 16740541,
    "author": {
      "name": `⏱️ | Uptime`
    }
  };
  message.channel.send({ embed });
    },
};