const db = require('quick.db')

module.exports = {
    name: 'q',
    aliases: [],
    category: 'fun',
    utilisation: '{prefix}q <otazka>',

    async execute(client, message, args) {
	const msg = message
    let r = Math.floor(Math.random() * (14 - 1 + 1)) + 1;
    let repl = "l"
    if(msg.channel.id === "760140761437438002") {
      msg.delete()
    } else {
    if(msg.content.includes("?")) {
    if(r == 1) {
      msg.reply("Ano")
    } else if(r == 2) {
      msg.reply("Ne")
    } else if(r == 3) {
      msg.reply("Nevim lol")
    } else if(r == 4) {
      msg.reply("hmm.. asi ne")
    } else if(r == 5) {
      msg.reply("hmm.. asi jo")
    } else if(r == 6) {
      msg.reply("Proč se mě na to vůbec ptáš.. já to nevím lol")
    } else if(r == 7) {
      msg.reply("Tvoje Máma hahaha.. haha.. ha..")
    } else if(r == 8) {
      msg.reply("Y E S")
    } else if(r == 9) {
      msg.reply("N O")
    } else if(r == 10) {
      msg.reply("hmm.. to fakt nevím")
    } else if(r == 11) {
      msg.reply("řeknu až mi pošleš nudes!")
    } else if(r == 12) {
      msg.reply("Jop!")
    } else if(r == 13) {
      msg.reply("N <:omegalul:572418415554330634>")
    } else if(r == 14) {
      msg.reply("<:yes:821837555518668810>")



    }
  } else if(msg.content.includes("yq")) {
    msg.reply("yg?")
  } else {
    msg.delete({timeout: 5000})
    msg.reply("Nezeptal/a jsi se na otázku!").then(msg => msg.delete({timeout: 5000}))
  }
	}
}
}