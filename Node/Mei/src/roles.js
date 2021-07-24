const firstMessage = require('./first-message')
const sendmessage = require('./send-message')

module.exports = (client) => {
  const channelId = '769904031446597663'

  const getEmoji = (emojiName) =>
    client.emojis.cache.find((emoji) => emoji.name === emojiName)

  const emojis = {
    RingingBell: '🔔 Oznámení',
    EV_Shard: '🔔 Giveaway',
    ohwow: '🔔 Sneak Peaks',
  }

  const reactions = []

  let emojiText = '> Reaguj pro **Rolu** :arrow_down:\n\n'
  for (const key in emojis) {
    const emoji = getEmoji(key)
    reactions.push(emoji)

    const role = emojis[key]
    emojiText += `${emoji} = \`${role}\`\n`
  }
	emojiText += '\n'
  firstMessage(client, channelId, emojiText, reactions)

  const handleReaction = (reaction, user, add) => {
    if (user.id === '760141340334882887') {
      return
    }

    const emoji = reaction._emoji.name

    const { guild } = reaction.message

    const roleName = emojis[emoji]
    if (!roleName) {
      return
    }

    const role = guild.roles.cache.find((role) => role.name === roleName)
    const member = guild.members.cache.find((member) => member.id === user.id)

    if (add) {
      member.roles.add(role)
      member.send(`${member}, byla ti přidána role \`${roleName}\``)
    } else {
      member.roles.remove(role)
      member.send(`${member}, byla ti odebrána role \`${roleName}\``)
    }

  }

  client.on('messageReactionAdd', (reaction, user) => {
    if (reaction.message.channel.id === channelId) {
      handleReaction(reaction, user, true)
    }
  })

  client.on('messageReactionRemove', (reaction, user) => {
    if (reaction.message.channel.id === channelId) {
      handleReaction(reaction, user, false)
    }
  })
}