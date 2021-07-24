const db = require('quick.db')

module.exports = {
    name: 'help',
    aliases: ['h'],
    category: 'Core',
    utilisation: '{prefix}help <command name>',

    execute(client, message, args) {
		let pref = db.get(`prefix_${message.guild.id}`)
		if (!pref) pref = "!";
        if (!args[0]) {
            const infos = message.client.commands.filter(x => x.category == 'Infos').map((x) => '`' + x.name + '`').join(', ');
            const gws = message.client.commands.filter(x => x.category == 'gws').map((x) => '`' + x.name + '`').join(', ');
            const tics = message.client.commands.filter(x => x.category == 'tickets').map((x) => '`' + x.name + '`').join(', ');

            message.channel.send({
                embed: {
                    color: 'PURPLE',
                    author: { name: 'Help Menu' },
                    footer: { text: 'www.evntvrs.fun' },
                    fields: [
                        { name: 'Bot', value: infos },
                        { name: 'Giveaway', value: gws },
                        { name: 'Tickets', value: tics },
  //                      { name: 'Owner Only', value: owner },
//                      { name: 'Filtre', value: client.filters.map((x) => '`' + x + '`').join(', ') },
                    ],
                    timestamp: new Date(),
                },
            });
        } else {
            const command = message.client.commands.get(args.join(" ").toLowerCase()) || message.client.commands.find(x => x.aliases && x.aliases.includes(args.join(" ").toLowerCase()));

            if (!command) return message.channel.send(`${client.emotes.error} - Tento príkaz som nenašiel!`);

            message.channel.send({
                embed: {
                    color: 'PURPLE',
                    author: { name: 'Help Menu' },
                    footer: { text: 'www.evntvrs.fun' },
                    fields: [
                        { name: 'Meno', value: command.name, inline: true },
                        { name: 'Kategoria', value: command.category, inline: true },
                        { name: 'Inakšie pomenovania', value: command.aliases.length < 1 ? 'None' : command.aliases.join(', '), inline: true },
                        { name: 'Využitie', value: command.utilisation.replace('{prefix}', pref), inline: true },
                    ],
                    timestamp: new Date(),
                    description: 'Najdeš informácie o cmds.\nPožadované argumenty `[]`, optimálne arkumenty `<>`.',
                }
            });
        };
    },
};