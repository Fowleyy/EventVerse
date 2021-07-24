const fs = require('fs');
const discord = require('discord.js');

const client = new discord.Client({ disableMentions: 'everyone' });

//client.config = require('./config/bot');
client.commands = new discord.Collection();

fs.readdirSync('./src/commands').forEach(dirs => {
    const commands = fs.readdirSync(`./src/commands/${dirs}`).filter(files => files.endsWith('.js'));

    for (const file of commands) {
        const command = require(`./commands/${dirs}/${file}`);
        console.log(`Loading command ${file}`);
        client.commands.set(command.name.toLowerCase(), command);
    };
});

const events = fs.readdirSync('./src/events').filter(file => file.endsWith('.js'));

for (const file of events) {
    console.log(`Loading discord.js event ${file}`);
    const event = require(`./events/${file}`);
    client.on(file.split(".")[0], event.bind(null, client));
};

const { GiveawaysManager } = require('discord-giveaways');
client.giveawaysManager = new GiveawaysManager(client, {
    storage: "./giveaways.json",
    updateCountdownEvery: 2000,
    default: {
        botsCanWin: false,
        embedColor: "#8800ff",
        reaction: "🎁"
    }
});

function makeid(length) {
    var result           = '';
    var characters       = 'ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789';
    var charactersLength = characters.length;
    for ( var i = 0; i < length; i++ ) {
       result += characters.charAt(Math.floor(Math.random() * charactersLength));
    }
    return result;
 }

 function makecommit(length) {
    var result           = '';
    var characters       = 'abcdefghijklmnopqrstuvwxyz00112233445566778899';
    var charactersLength = characters.length;
    for ( var i = 0; i < length; i++ ) {
       result += characters.charAt(Math.floor(Math.random() * charactersLength));
    }
    return result;
 }

client.on('message', msg => {
    if(msg.content === "!claim") {
        const embed = {
            "title": "❌ | ERROR!",
            "description": "Žádná odměna není dostupná!",
            "color": 13632027
            };
        msg.delete({timeout: 5000});
        msg.channel.send({ embed }).then(msg => msg.delete({timeout: 5000}))
       }

})

client.on('message', msg => {
    if(msg.content == "1st") {
        msg.delete()
    }
})

client.on('message', msg => {
    if(msg.channel.id == "760140761437438002") {
        if(!(msg.member.id === "760141340334882887")) {
            if(!(msg.member.id === "332594189911195649")) {
                if(!(msg.member.id === "345970645252702209")) {
        msg.delete()
        const re1 = client.emojis.cache.find(emoji => emoji.name === "yes_full");
        const re2 = client.emojis.cache.find(emoji => emoji.name === "no_full");
        let content = msg.content.replace("!napad ", "");
        const embed = {
            "title": "📃 | **Nápad**",
            "description": content,
            "color": 4886754
          };
          if(msg.content.includes("http://")) {
            msg.member.send("> **‣** <:no_full:800673846650208256> | **Nápady nesmí obsahovat odkaz!**")
        } else if(msg.content.includes("www.")) {
            msg.member.send("> **‣** <:no_full:800673846650208256> | **Nápady nesmí obsahovat odkaz!**")
        } else if (msg.content.includes("https://")) {
            msg.member.send("> **‣** <:no_full:800673846650208256> | **Nápady nesmí obsahovat odkaz!**")
        } else if (msg.content.startsWith("!")) {
            msg.member.send("> **‣** <:no_full:800673846650208256> | **Nápady nesmí obsahovat command!**") 
        } else if (msg.content.includes("@")) {
            msg.member.send("> **‣** <:no_full:800673846650208256> | **Nápady nesmí obsahovat ping!**")
        } else {
        msg.channel.send({ embed }).then(msg => {
            msg.react(re1);
            msg.react(re2)
            
        })
        }
    }}
}
    }
})



client.on('message', msg => {
    if(msg.channel.id == "760140761437438002") {
        if(!(msg.member.id === "760141340334882887")) {
            if(!(msg.member.id === "332594189911195649")) {
                if(!(msg.member.id === "345970645252702209")) {
        let content = msg.content.replace("!napad ", "");
        let logch = msg.guild.channels.cache.get("814530977686749184")
        const embed = {
            "title": "**Nápad Vytvořen**",
            "description": "```\n" +content +"```\n**Autor:** <@" +msg.member.id +">",
            "color": 4886754 
          };
          if(msg.content.includes("http://")) {
            msg.member.send("> **‣** <:no_full:800673846650208256> | **Nápady nesmí obsahovat odkaz!**")
        } else if(msg.content.includes("www.")) {
            msg.member.send("> **‣** <:no_full:800673846650208256> | **Nápady nesmí obsahovat odkaz!**")
        } else if (msg.content.includes("https://")) {
            msg.member.send("> **‣** <:no_full:800673846650208256> | **Nápady nesmí obsahovat odkaz!**")
        } else if (msg.content.startsWith("!")) {
            msg.member.send("> **‣** <:no_full:800673846650208256> | **Nápady nesmí obsahovat command!**") 
        } else if (msg.content.includes("@")) {
            msg.member.send("> **‣** <:no_full:800673846650208256> | **Nápady nesmí obsahovat ping!**")
        } else {
        logch.send({ embed })
        }
    }}
}
    }
})



client.on("guildMemberAdd", member => {
    const embed = {
      "title": "➤ **Vítej na EventVerse** 👋",
      "description": "\nVítej, **" +member.user.username +"** na discord serveru **EventVerse**\n\n Jsme tým, který se zabývá tvorbou kvalitních minecraft eventů a turnajů na naší scéně. Před vstupem si prosím přečti <#760138924285886484>, a také <#845422873152978965>\n\n",
      "color": 9442302,
      "thumbnail": {
        "url": "https://media.discordapp.net/attachments/853255355722891274/853259683606691870/EV_Logo.png"
      }
    };
    member.send({ embed });
//    console.log("joined")
});




client.on('message', msg => {
    if(msg.content.includes("!napad")) {
        msg.delete({ timeout: 5000 })
        if(!(msg.channel.id = "760140761437438002"))
        msg.channel.send("> **‣** ⚠️ | **<@" +msg.member.id +">, Napiš zprávu do kanálu <#760140761437438002> pro odeslání nápadu!**").then(msg => {
            msg.delete({ timeout: 5000 })
        })
    }
})


client.on('message', msg => {
    if(msg.content == "!changelog-mces-2.0.2") {
        if(msg.member.id === "332594189911195649") {
        msg.delete()
// CHANGELOG EMBED BEGIN
const embed = {
    "title": "**➤ \📃** EventVerse patch 2.0.2",
    "description": " **──────────────────────────** \n \n `Novinky` \n > ‣ <:yes_full:820079261212999720>**〡Rozšířená podpora pro jiné verze:** Na Event server se nyní dá připojit s 1.7.10 - 1.17.1-pre1\n \n ────────────────────────── \n \n ",
    "color": 10763775,
    "footer": {
    "text": "Autor: 寂しい Lukynka#0164 | ID: " +makecommit(5)
    }
    };
    msg.channel.send("<@&760153844075200622>", { embed });
   // msg.channel.send({ embed });
    // CHANGELOG EMBED END
    
    
    
            
        }   
    }
})
