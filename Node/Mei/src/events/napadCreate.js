module.exports = async (client, message) => {
    let channel = message.guild.channels.cache.get("814530977686749184")
    const embed = {
      "title": "Nápad vytvořen",
      "description": "```" +message.content +"```**Autor:** <@" +message.member.id +">",
      "color": "BLUE"
    };
    if(message.channel.id == "828337370058326086") {
      channel.send({ embed });
    }
}