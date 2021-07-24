const roleClaim = require('../roles')

const activities_list = [
    "Hole in the Wall", 
    "Parkour",
    "Splashdown",
    "TNT Tag",
    "Block Party",
    "Spleef",
    "Rocket Spleef", 
    "si na admina"
    ];

module.exports = async (client) => {
    console.log(`Ready on ${client.guilds.cache.size} servers, for a total of ${client.users.cache.size} users`);
	roleClaim(client)
    setInterval(() => {
        const index = Math.floor(Math.random() * (activities_list.length - 1) + 1); 
        client.user.setPresence({
            status : "online",
            activity : {
                name : activities_list[index],
                type : "PLAYING",
            }
        }); 
    }, 10000); 
};
