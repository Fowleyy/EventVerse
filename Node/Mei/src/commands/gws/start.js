const ms = require('ms');

module.exports = {
    name: 'gstart',
    aliases: [],
    category: 'gws',
    utilisation: '{prefix}gstart <channel> <duration> <winners> <cena>',

    execute(client, message, args) {

    // If the member doesn't have enough permissions
    if(!message.member.hasPermission('ADMINISTRATOR') && !message.member.roles.cache.some((r) => r.name === "Giveaways")){
        return message.channel.send('> **‣** <:no_full:800673846650208256> | **Musíš mít oprávnění **ADMINISTRATOR** aby si mohl/a začít giveaway!**');
    }

    // Giveaway channel
    let giveawayChannel = message.mentions.channels.first();
    // If no channel is mentionned
    if(!giveawayChannel){
        return message.channel.send('> **‣** <:no_full:800673846650208256> | **Musíš označit platný kanál!**');
    }

    // Giveaway duration
    let giveawayDuration = args[1];
    // If the duration isn't valid
    if(!giveawayDuration || isNaN(ms(giveawayDuration))){
        return message.channel.send('> **‣** <:no_full:800673846650208256> | **Musíš uvést platnou dobu trvání!**');
    }

    // Number of winners
    let giveawayNumberWinners = args[2];
    // If the specified number of winners is not a number
    if(isNaN(giveawayNumberWinners) || (parseInt(giveawayNumberWinners) <= 0)){
        return message.channel.send('> **‣** <:no_full:800673846650208256> | **Musíš uvést platný počet výherců!!**');
    }

    // Giveaway prize
    let giveawayPrize = args.slice(3).join(' ');
    // If no prize is specified
    if(!giveawayPrize){
        return message.channel.send('> **‣** <:no_full:800673846650208256> | **Musíš uvést platnou cenu!**');
    }

    // Start the giveaway
    client.giveawaysManager.start(giveawayChannel, {
        // The giveaway duration
        time: ms(giveawayDuration),
        // The giveaway prize
        prize: giveawayPrize,
        // The giveaway winner count
        winnerCount: giveawayNumberWinners,
        // Who hosts this giveaway
        hostedBy: message.author,
        // Messages
        messages: {
            giveaway: "▬▬▬▬▬▬▬▬▬▬\n🪐 **G I V E A W A Y** \\🌌\n▬▬▬▬▬▬▬▬▬▬",
            giveawayEnded: "▬▬▬▬▬▬▬▬▬▬\n🪐 **G I V E A W A Y** \\🌌\n▬▬▬▬▬▬▬▬▬▬",
            timeRemaining: "\nZbývá času: **{duration}**",
            inviteToParticipate: "Reaguj pomocí \🎁 aby jsi se zúčastnil/a",
            winMessage: "> **‣**\\🎉 **|** Gratulujeme, {winners}! Vyhrál/a jsi **{prize}**",
            embedFooter: "Giveawaye",
            noWinner: "Giveaway zrušena, nedostatek přihlášených lidí.",
            hostedBy: "Hostuje: {user}",
            winners: "Vítěz(ové)",
            endedAt: "Skončila v",
            units: {
                seconds: "s",
                minutes: "m",
                hours: "h",
                days: "d",
                pluralS: false // Not needed, because units end with a S so it will automatically removed if the unit value is lower than 2
            }
        }
    });

    message.channel.send(`> **‣** <:yes_full:820079261212999720> | **Giveaway začala v ${giveawayChannel}!**`);
  }
};