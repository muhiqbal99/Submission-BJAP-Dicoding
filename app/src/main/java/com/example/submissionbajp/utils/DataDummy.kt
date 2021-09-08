package com.example.submissionbajp.utils

import com.example.submissionbajp.R
import com.example.submissionbajp.data.source.local.entity.Movie
import com.example.submissionbajp.data.source.local.entity.TvShow

object DataDummy {
    fun getMovie(): ArrayList<Movie> {
        val listMovies = ArrayList<Movie>()

        listMovies.add(
            Movie(
                588228,
                "The Tomorrow War",
                "2021-09-03",
                7.8,
                "The world is stunned when a group of time travelers arrive from the year 2051 to deliver an urgent message: Thirty years in the future, mankind is losing a global war against a deadly alien species. The only hope for survival is for soldiers and civilians from the present to be transported to the future and join the fight. Among those recruited is high school teacher and family man Dan Forester. Determined to save the world for his young daughter, Dan teams up with a brilliant scientist and his estranged father in a desperate quest to rewrite the fate of the planet.",
                R.drawable.poster_tommorow_war
            )
        )

        listMovies.add(
            Movie(
                566525,
                "Shang-Chi and the Legend of the Ten Rigns",
                "01-09-2021",
                8.0,
                "Shang-Chi must confront the past he thought he left behind when he is drawn into the web of the mysterious Ten Rings organization.",
                R.drawable.poster_shangchi
            )
        )

        listMovies.add(
            Movie(
                482373,
                "Don't Breathe 2",
                "12-08-2021",
                7.7,
                "The Blind Man has been hiding out for several years in an isolated cabin and has taken in and raised a young girl orphaned from a devastating house fire. Their quiet life together is shattered when a group of criminals kidnap the girl, forcing the Blind Man to leave his safe haven to save her.",
                R.drawable.poster_dont_breathe2
            )
        )

        listMovies.add(
            Movie(
                436969,
                "The Suicide Squad",
                "28-07-2021",
                8.0,
                "Supervillains Harley Quinn, Bloodsport, Peacemaker and a collection of nutty cons at Belle Reve prison join the super-secret, super-shady Task Force X as they are dropped off at the remote, enemy-infused island of Corto Maltese.",
                R.drawable.poster_the_suicide_squad
            )
        )

        listMovies.add(
            Movie(
                451048,
                "Jungle Cruise",
                "28-07-2021",
                7.9,
                "Dr. Lily Houghton enlists the aid of wisecracking skipper Frank Wolff to take her down the Amazon in his dilapidated boat. Together, they search for an ancient tree that holds the power to heal – a discovery that will change the future of medicine.",
                R.drawable.poster_jungle_cruise
            )
        )

        listMovies.add(
            Movie(
                497698,
                "Black Widow",
                "07-07-2021",
                7.8,
                "Natasha Romanoff, also known as Black Widow, confronts the darker parts of her ledger when a dangerous conspiracy with ties to her past arises. Pursued by a force that will stop at nothing to bring her down, Natasha must deal with her history as a spy and the broken relationships left in her wake long before she became an Avenger.",
                R.drawable.poster_black_widow
            )
        )

        listMovies.add(
            Movie(
                619297,
                "Sweet Girl",
                "18-08-2021",
                6.9,
                "A devastated husband vows to bring justice to the people responsible for his wife's death while protecting the only family he has left, his daughter.",
                R.drawable.poster_sweet_girl
            )
        )

        listMovies.add(
            Movie(
                675445,
                "PAW Patrol: The Movie",
                "09-08-2021",
                8.0,
                "Ryder and the pups are called to Adventure City to stop Mayor Humdinger from turning the bustling metropolis into a state of chaos.",
                R.drawable.poster_paw_patrol
            )
        )

        listMovies.add(
            Movie(
                379686,
                "Space Jam: A New Legacy",
                "08-07-2021",
                7.4,
                "When LeBron and his young son Dom are trapped in a digital space by a rogue A.I., LeBron must get them home safe by leading Bugs, Lola Bunny and the whole gang of notoriously undisciplined Looney Tunes to victory over the A.I.'s digitized champions on the court. It's Tunes versus Goons in the highest-stakes challenge of his life.",
                R.drawable.poster_spacejam
            )
        )

        listMovies.add(
            Movie(
                9,
                "After We Fell",
                "01-09-2021",
                8.7,
                "Just as Tessa's life begins to become unglued, nothing is what she thought it would be. Not her friends nor her family. The only person that she should be able to rely on is Hardin, who is furious when he discovers the massive secret that she's been keeping. Before Tessa makes the biggest decision of her life, everything changes because of revelations about her family.",
                R.drawable.poster_after_we_fell
            )
        )
        return listMovies
    }

    fun getTvShow(): List<TvShow> {
        val listTvShow = ArrayList<TvShow>()

        listTvShow.add(
            TvShow(
                71446,
                "Money Heist",
                "2017-05-02",
                8.3,
                "To carry out the biggest heist in history, a mysterious man called The Professor recruits a band of eight robbers who have a single characteristic: none of them has anything to lose. Five months of seclusion - memorizing every step, every detail, every probability - culminate in eleven days locked up in the National Coinage and Stamp Factory of Spain, surrounded by police forces and with dozens of hostages in their power, to find out whether their suicide wager will lead to everything or nothing.",
                "/MoEKaPFHABtA1xKoOteirGaHl1.jpg"
            )
        )
//
//        listTvShow.add(
//            TvShow(
//                11,
//                "Shameless",
//                "2011-2021",
//                8.5,
//                "Watch the Irish American family the Gallaghers dealing with their alcoholic father Frank. Fiona, the eldest daughter, takes the role of the parent to her five brothers and sisters. Lip, Ian, Debbie, Carl, and Liam deal with life on the South Side of Chicago. Fiona balances her sex life and raising her siblings",
//                R.drawable.poster_shameless
//            )
//        )
//
//        listTvShow.add(
//            TvShow(
//                12,
//                "Gotham",
//                "2014-2019",
//                7.8,
//                "In crime ridden Gotham City, Thomas and Martha Wayne are murdered before young Bruce Wayne's eyes. Although Gotham City Police Department detectives, James Gordon, and his cynical partner, Harvey Bullock, seem to solace's the case quickly, things are not so simple. Inspired by Bruce's traumatized desire for justice, Gordon vows to find it amid Gotham's corruption. ",
//                R.drawable.poster_gotham
//            )
//        )
//
//        listTvShow.add(
//            TvShow(
//                13,
//                "Arrow",
//                "2012-2020",
//                7.5,
//                "Oliver Queen and his father are lost at sea when their luxury yacht sinks, apparently in a storm. His father dies, but Oliver survives for five years on an uncharted island and eventually returns home. But he wasn't alone on the island where he learned not only how to fight and survive but also of his father's corruption and unscrupulous business dealings. He returns to civilization a changed man, determined to put things right. ",
//                R.drawable.poster_arrow
//            )
//        )
//
//        listTvShow.add(
//            TvShow(
//                14,
//                "The Walking Dead",
//                "2010-Now",
//                8.2,
//                "Sheriff Deputy Rick Grimes gets shot and falls into a coma. When awoken he finds himself in a Zombie Apocalypse. Not knowing what to do he sets out to find his family, after he's done that, he gets connected to a group to become the leader. He takes charge and tries to help this group of people survive, find a place to live and get them food. This show is all about survival, the risks and the things you'll have to do to survive.",
//                R.drawable.poster_the_walking_dead
//            )
//        )
//
//        listTvShow.add(
//            TvShow(
//                15,
//                "Ncis",
//                "2003",
//                7.7,
//                "Special Agent Leroy Jethro Gibbs is the leader of a team of special agents belonging to the NCIS (Naval Criminal Investigative Service) Major Case Response Team. Gibbs, a former Marine, is a tough investigator and a highly skilled interrogator who relies on his gut instinct as much as evidence. Gibbs' second in command is Senior Field Agent Tony DiNozzo, a womanizing, TvShow-quoting former Baltimore Homicide Detective, who despite being the class clown always gets the job done.",
//                R.drawable.poster_ncis
//            )
//        )
//
//        listTvShow.add(
//            TvShow(
//                16,
//                "Doom Patrol",
//                "2019",
//                7.9,
//                "A re-imagining of one of DC's most beloved group of outcast Super Heroes: Robotman, Negative Man, Elasti-Girl and Crazy Jane, led by modern-day mad scientist Dr. Niles Caulder (The Chief). The Doom Patrol's members each suffered horrible accidents that gave them superhuman abilities - but also left them scarred and disfigured. Traumatized and downtrodden, the team found purpose through The Chief, who brought them together to investigate the weirdest phenomena in existence - and to protect Earth from what they find.",
//                R.drawable.poster_doom_patrol
//            )
//        )
//
//        listTvShow.add(
//            TvShow(
//                17,
//                "The Flash",
//                "2014-Now",
//                7.6,
//                "Barry Allen is a Central City police forensic scientist with a reasonably happy life, despite the childhood trauma of a mysterious red and yellow lightning killing his mother and framing his father. All that changes when a massive particle accelerator accident leads to Barry being struck by lightning in his lab. Coming out of coma nine months later, Barry and his new friends at S.T.A.R labs find that he now has the ability to move at superhuman speed. ",
//                R.drawable.poster_flash
//            )
//        )
//
//        listTvShow.add(
//            TvShow(
//                18,
//                "Iron Fist",
//                "2017-2018",
//                8.1,
//                "Danny Rand returns to New York City after being missing for years, trying to reconnect with his past and his family legacy. He fights against the criminal element corrupting his world around him with his incredible kung-fu mastery and ability to summon the awesome power of the fiery Iron Fist.",
//                R.drawable.poster_iron_fist
//            )
//        )
//
//        listTvShow.add(
//            TvShow(
//                19,
//                "Riverdale",
//                "2017-Now",
//                6.8,
//                "After the death of one of the rich and popular Blossom twins on the 4th of July, the small town of Riverdale investigates the murder. The series starts in September, the beginning of a new school year, that brings with it new students, relationships, and reveals the mysteries of the past 4th of July.",
//                R.drawable.poster_riverdale
//            )
//        )
        return listTvShow
    }
}