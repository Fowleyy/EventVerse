const ms = require('ms');

module.exports = {
    name: 'greroll',
    aliases: [],
    category: 'gws',
    utilisation: '{prefix}greroll <gw id>',

    execute(client, message, args) {

    // If the member doesn't have enough permissions
    if(!message.member.hasPermission('MANAGE_MESSAGES') && !message.member.roles.cache.some((r) => r.name === "Giveaways")){
        return message.channel.send('> **‣** <:no_full:800673846650208256> | **Musíš mít oprávnění **ADMINISTRATOR** aby jsi mohl/a rerollnout giveaway!**');
    }

    // If no message ID or giveaway name is specified
    if(!args[0]){
        return message.channel.send('<:no:767754183444398101> Musíš uvést platné ID zprávy giveawaye');
    }

    // try to found the giveaway with prize then with ID
    let giveaway = 
    // Search with giveaway prize
    client.giveawaysManager.giveaways.find((g) => g.prize === args.join(' ')) ||
    // Search with giveaway ID
    client.giveawaysManager.giveaways.find((g) => g.messageID === args[0]);

    // If no giveaway was found
    if(!giveaway){
        return message.channel.send('<:no:767754183444398101> Nelze nalézt giveaway pro `'+ args.join(' ') +'`.');
    }

    // Reroll the giveaway
    client.giveawaysManager.reroll(giveaway.messageID)
    .then(() => {
        // Success message
        message.channel.send('Giveaway vylosovala nového vítěze!!');
    })
    .catch((e) => {
        if(e.startsWith(`Giveaway z ID zprávy ${giveaway.messageID} neskončila`)){
            message.channel.send('<:no:767754183444398101> Tahle giveaway neskončila!');
        } else {
            console.error(e);
            message.channel.send('<:no:767754183444398101> Nastal nečekaný problém, kontaktuj **"JopGamer |🐘#3485** pokud se tato chyba bude opakovat!');
        }
    });
  }
};
