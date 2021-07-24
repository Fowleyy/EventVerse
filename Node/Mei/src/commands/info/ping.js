module.exports = {
    name: 'ping',
    aliases: [],
    category: 'Infos',
    utilisation: '{prefix}ping',

    execute(client, message) {
        message.channel.send(`:white_check_mark: - Ping : **${client.ws.ping}ms** !`);
    },
};