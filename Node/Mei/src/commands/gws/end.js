const ms = require('ms');

module.exports = {
    name: 'gend',
    aliases: [],
    category: 'gws',
    utilisation: '{prefix}gend <gw id>',

    execute(client, message, args) {

    // If the member doesn't have enough permissions
    if(!message.member.hasPermission('MANAGE_MESSAGES') && !message.member.roles.cache.some((r) => r.name === "Giveaways")){
        return message.channel.send('> **‣** <:no_full:800673846650208256> | **Musíš mít oprávnění **ADMINISTRATOR** aby jsi mohl/a ukončit giveaway!**');
    }

    // If no message ID or giveaway name is specified
    if(!args[0]){
        return message.channel.send('> **‣** <:no_full:800673846650208256> | **Musíš uvést správné ID zprávy aby jsi mohl/a ukončit giveaway!**');
    }

    // try to found the giveaway with prize then with ID
    let giveaway = 
    // Search with giveaway prize
    client.giveawaysManager.giveaways.find((g) => g.prize === args.join(' ')) ||
    // Search with giveaway ID
    client.giveawaysManager.giveaways.find((g) => g.messageID === args[0]);

    // If no giveaway was found
    if(!giveaway){
        return message.channel.send('> **‣** <:no_full:800673846650208256> | **Nelze nalést giveaway s id **`'+ args.join(' ') + '`**.**');
    }

    // Edit the giveaway
    client.giveawaysManager.edit(giveaway.messageID, {
        setEndTimestamp: Date.now()
    })
    // Success message
    .then(() => {
        // Success message
        message.channel.send('Giveaway skončí za '+(client.giveawaysManager.options.updateCountdownEvery/1000)+' sekund');
    })
    .catch((e) => {
        if(e.startsWith(`<:no:767754183444398101> Giveaway s ID ${giveaway.messageID} už neprobíhá!`)){
            message.channel.send('<:no:767754183444398101> Giveaway s ID ${giveaway.messageID} už neprobíhá!');
        } else {
            console.error(e);
            message.channel.send('<:no:767754183444398101> Nastal nečekaný problém, kontaktuj **"JopGamer |🐘#3485** pokud se tato chyba bude opakovat!');
        }
    });
  }
};
