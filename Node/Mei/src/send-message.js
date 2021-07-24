const discord = require('discord.js');

module.exports = async (client, channelID, text, duration = 10) => {
	const channel = await client.channels.fetch(channelID)
	channel.send(text).then((message) => {
		if (duration === -1) {
			return
		}

		setTimeout(() => {
			message.delete()
		}, 1000 * duration)
	})
}