module.exports = async (client, message) => {
    let channel = message.guild.channels.cache.get("814530977686749184")
    const embed = {
      "title": "Zpráva odstraněna",
      "description": "```" +message.content +"```**Autor:** <@" +message.member.id +">\n**Channel:** <#" +message.channel +">",
      "color": "RED"
    };
    if(!(message.channel.id == "760140761437438002")) {
      channel.send({ embed });
    }
}