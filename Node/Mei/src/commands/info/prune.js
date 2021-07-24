module.exports = {
    name: 'prune',
    aliases: [],
    category: 'Admin',
    utilisation: '{prefix}prune',

    execute(client, message) {

  const embed = {
	"color": "RED",
    "description": "**Proběhl prune..**\nByl kicknut __**1**__ člen!",
 //   "color": 16711765,
    "author": {
      "name": `❌ | Prune`
    }
  };
  message.delete()
  if(message.member.id == "332594189911195649") {
      message.channel.send({ embed });
    }
  }
};