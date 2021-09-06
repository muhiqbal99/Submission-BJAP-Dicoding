package com.example.submissionbajp.utils

import com.example.submissionbajp.R
import com.example.submissionbajp.model.Movie

object DataDummy {
    fun getMovie(): ArrayList<Movie> {
        val listMovies = ArrayList<Movie>()

        listMovies.add(
            Movie(
                0,
                "Avengers: Infinity War",
                "14/02/2019",
                "2hr 2m",
                "Action, Adventure, Sci-Fi",
                "8.4/10",
                "As the Avengers and their allies have continued to protect the world from threats too large for any one hero to handle, a new danger has emerged from the cosmic shadows: Thanos. A despot of intergalactic infamy, his goal is to collect all six Infinity Stones, artifacts of unimaginable power, and use them to inflict his twisted will on all of reality. Everything the Avengers have fought for has led up to this moment, the fate of Earth and existence has never been more uncertain.",
                R.drawable.poster_infinity_war
            )
        )

        listMovies.add(
            Movie(
                1,
                "The Suicide Squad",
                "28/07/2021",
                "2hr 12m",
                "Action, Adventure, Comedy",
                "7.5/10",
                "Supervillains Harley Quinn, Bloodsport, Peacemaker and a collection of nutty cons at Belle Reve prison join the super-secret, super-shady Task Force X as they are dropped off at the remote, enemy-infused island of Corto Maltese.",
                R.drawable.poster_the_suicide_squad
            )
        )

        listMovies.add(
            Movie(
                2,
                "Vivo",
                "03/06/2019",
                "1h 35m",
                "Animation, Action, Adventure",
                "6.8/10",
                "Vivo follows a one-of-kind kinkajou (aka a rainforest \"honey bear\") who spends his days playing music to the crowds in a lively square with his beloved owner Andrés. Though they may not speak the same language, Vivo and Andrés are the perfect duo through their common love of music.",
                R.drawable.poster_vivo
            )
        )

        listMovies.add(
            Movie(
                3,
                "Jungle Cruise",
                "28/07/2018",
                "2h 7m",
                "Action, Adventure, Comedy",
                "6.7/10",
                "Based on Disneyland's theme park ride where a small riverboat takes a group of travelers through a jungle filled with dangerous animals and reptiles but with a supernatural element.",
                R.drawable.poster_jungle_cruise
            )
        )

        listMovies.add(
            Movie(
                4,
                "Aftermath",
                "14/02/2019",
                "1h 54m",
                "Drama, Horror, Mystery",
                "5.3/10",
                "A young couple struggling to stay together, when they are offered an amazing deal on a home with a questionable past that would normally be beyond their means. In a final attempt to start fresh as a couple they take the deal.",
                R.drawable.poster_aftermath
            )
        )

        listMovies.add(
            Movie(
                5,
                "How to train dragon; The hidden world",
                "09/01/2019",
                "1h 44m",
                "Animation, Action, Adventure",
                "7.5/10",
                "As Hiccup fulfills his dream of creating a peaceful dragon utopia, Toothless' discovery of an untamed, elusive mate draws the Night Fury away. When danger mounts at home and Hiccup's reign as village chief is tested, both dragon and rider must make impossible decisions to save their kind.",
                R.drawable.poster_how_to_train
            )
        )

        listMovies.add(
            Movie(
                6,
                "Spider-Man",
                "12/12/2018",
                "1hr 57m",
                "Animation, Action, Adventure",
                "8.4/10",
                "Phil Lord and Christopher Miller, the creative minds behind The Lego Movie and 21 Jump Street, bring their unique talents to a fresh vision of a different Spider-Man Universe, with a groundbreaking visual style that's the first of its kind. \"Spider-Man(TM): Into the Spider-Verse\" introduces Brooklyn teen Miles Morales (Shameik Moore), and the limitless possibilities of the Spider-Verse, where more than one can wear the mask.",
                R.drawable.poster_spiderman
            )
        )

        listMovies.add(
            Movie(
                7,
                "Robin Hood",
                "20/11/2018",
                "1h 56m",
                "Action, Adventure, Drama",
                "5.3/10",
                "Robin of Loxley, a lord living in Nottingham, enjoys a good life with his lover, Marian, before he is drafted by the corrupt Sheriff of Nottingham to fight in the Third Crusade against the Saracens. After four years away from England, Robin becomes disillusioned with the Crusades when he fails to prevent his commander, Guy of Gisbourne, from executing prisoners, namely a teenage boy, despite the pleading of the boy's father, which prompts Gisbourne to send Robin back home.",
                R.drawable.poster_robin_hood
            )
        )

        listMovies.add(
            Movie(
                8,
                "Glass",
                "18/01/2019",
                "2h 9m",
                "Thriller, Drama, Science Fiction",
                "6.6/10",
                "After pursuing Kevin Wendell Crumb and the multiple identities that reside within, David Dunn finds himself locked in a mental hospital alongside his archenemy, Elijah Price. The trio must now contend with a psychiatrist, who is out to prove they do not actually possess superhuman abilities.",
                R.drawable.poster_glass
            )
        )

        listMovies.add(
            Movie(
                9,
                "Freeguy",
                "10/08/2021",
                "1h 55m",
                "Action, Comedy, Sci-Fi",
                "7.7/10",
                "A bank teller discovers that he's actually an NPC inside a brutal, open world video game.",
                R.drawable.poster_freeguy
            )
        )
        return listMovies
    }

    fun getTvShow(): List<Movie> {
        val listTvShow = ArrayList<Movie>()

        listTvShow.add(
            Movie(
                10,
                "Supergirl",
                "2015-2021",
                "43m",
                "Action, Adventure, Drama",
                "6.2/10",
                "Years ago, Krypton was about to explode and Kal-El was sent to Earth to escape that fate. However, his older cousin, Kara, was also intended to accompany the infant as his protector. Unfortunately, Kara was accidentally diverted into the timeless Phantom Zone for years before finally arriving on Earth decades later and found by her cousin who had grown into Superman. Years later, Kara Danvers is a young professional adrift in a thankless job until a fateful crisis ignites a sense of purpose using Kryptonian powers she had long hidden.",
                R.drawable.poster_supergirl
            )
        )

        listTvShow.add(
            Movie(
                11,
                "Shameless",
                "2011-2021",
                "46m",
                "Comedy, Drama",
                "8.5/10",
                "Watch the Irish American family the Gallaghers dealing with their alcoholic father Frank. Fiona, the eldest daughter, takes the role of the parent to her five brothers and sisters. Lip, Ian, Debbie, Carl, and Liam deal with life on the South Side of Chicago. Fiona balances her sex life and raising her siblings",
                R.drawable.poster_shameless
            )
        )

        listTvShow.add(
            Movie(
                12,
                "Gotham",
                "2014-2019",
                "42m",
                "Action, Crime, Drama",
                "7.8/10",
                "In crime ridden Gotham City, Thomas and Martha Wayne are murdered before young Bruce Wayne's eyes. Although Gotham City Police Department detectives, James Gordon, and his cynical partner, Harvey Bullock, seem to solace's the case quickly, things are not so simple. Inspired by Bruce's traumatized desire for justice, Gordon vows to find it amid Gotham's corruption. ",
                R.drawable.poster_gotham
            )
        )

        listTvShow.add(
            Movie(
                13,
                "Arrow",
                "2012-2020",
                "42m",
                "Action, Adventure, Crime",
                "7.5/10",
                "Oliver Queen and his father are lost at sea when their luxury yacht sinks, apparently in a storm. His father dies, but Oliver survives for five years on an uncharted island and eventually returns home. But he wasn't alone on the island where he learned not only how to fight and survive but also of his father's corruption and unscrupulous business dealings. He returns to civilization a changed man, determined to put things right. ",
                R.drawable.poster_arrow
            )
        )

        listTvShow.add(
            Movie(
                14,
                "The Walking Dead",
                "2010-Now",
                "44m",
                "Drama, Horror, Thriller",
                "8.2/10",
                "Sheriff Deputy Rick Grimes gets shot and falls into a coma. When awoken he finds himself in a Zombie Apocalypse. Not knowing what to do he sets out to find his family, after he's done that, he gets connected to a group to become the leader. He takes charge and tries to help this group of people survive, find a place to live and get them food. This show is all about survival, the risks and the things you'll have to do to survive.",
                R.drawable.poster_the_walking_dead
            )
        )

        listTvShow.add(
            Movie(
                15,
                "Ncis",
                "2003",
                "1h",
                "Action, Crime, Drama",
                "7.7/10",
                "Special Agent Leroy Jethro Gibbs is the leader of a team of special agents belonging to the NCIS (Naval Criminal Investigative Service) Major Case Response Team. Gibbs, a former Marine, is a tough investigator and a highly skilled interrogator who relies on his gut instinct as much as evidence. Gibbs' second in command is Senior Field Agent Tony DiNozzo, a womanizing, movie-quoting former Baltimore Homicide Detective, who despite being the class clown always gets the job done.",
                R.drawable.poster_ncis
            )
        )

        listTvShow.add(
            Movie(
                16,
                "Doom Patrol",
                "2019",
                "1h",
                "Action, Adventure, Comedy",
                "7.9/10",
                "A re-imagining of one of DC's most beloved group of outcast Super Heroes: Robotman, Negative Man, Elasti-Girl and Crazy Jane, led by modern-day mad scientist Dr. Niles Caulder (The Chief). The Doom Patrol's members each suffered horrible accidents that gave them superhuman abilities - but also left them scarred and disfigured. Traumatized and downtrodden, the team found purpose through The Chief, who brought them together to investigate the weirdest phenomena in existence - and to protect Earth from what they find.",
                R.drawable.poster_doom_patrol
            )
        )

        listTvShow.add(
            Movie(
                17,
                "The Flash",
                "2014-Now",
                "43m",
                "Action, Adventure, Drama",
                "7.6/10",
                "Barry Allen is a Central City police forensic scientist with a reasonably happy life, despite the childhood trauma of a mysterious red and yellow lightning killing his mother and framing his father. All that changes when a massive particle accelerator accident leads to Barry being struck by lightning in his lab. Coming out of coma nine months later, Barry and his new friends at S.T.A.R labs find that he now has the ability to move at superhuman speed. ",
                R.drawable.poster_flash
            )
        )

        listTvShow.add(
            Movie(
                18,
                "Iron Fist",
                "2017-2018",
                "55m",
                "Action, Adventure, Crime",
                "8.1/10",
                "Danny Rand returns to New York City after being missing for years, trying to reconnect with his past and his family legacy. He fights against the criminal element corrupting his world around him with his incredible kung-fu mastery and ability to summon the awesome power of the fiery Iron Fist.",
                R.drawable.poster_iron_fist
            )
        )

        listTvShow.add(
            Movie(
                19,
                "Riverdale",
                "2017-Now",
                "45m",
                "Crime, Drama, Mystery",
                "6.8/10",
                "After the death of one of the rich and popular Blossom twins on the 4th of July, the small town of Riverdale investigates the murder. The series starts in September, the beginning of a new school year, that brings with it new students, relationships, and reveals the mysteries of the past 4th of July.",
                R.drawable.poster_riverdale
            )
        )
        return listTvShow
    }
}