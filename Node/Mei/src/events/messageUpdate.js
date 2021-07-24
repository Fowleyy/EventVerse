module.exports = async (client, oldmsg, newmsg) => {
  let channel = oldmsg.guild.channels.cache.get("814530977686749184")
  if(oldmsg.member.roles.cache.has("760143211657953319")) {
    var pog = oldmsg.content
  } else {
  const embed = {
    "title": "Zpráva Upravena",
    "description": "**Stará zpráva:\n```" +oldmsg.content +"```\n**Nová zpráva:\n```" +newmsg.content +"\n```**Autor:** <@" +newmsg.member.id +">\n**Channel:** <#" +newmsg.channel +">",
    "color": "ORANGE"
  };
  channel.send({ embed });
  }
}