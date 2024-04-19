package com.example.myapplication.model

class UserService {
    private var users:MutableList<User> = mutableListOf<User>()


    init{
        IMAGES.shuffle()

        users.add(User(
            id = 1,
            name = "Сыроежкин Аркадий Михайлович",
            jobTitle = "ветеринар",
            experience =  "Опыт работы: В 2016 работал в качестве ассистента в клинике при университете. С 2017 года проходил практику и ассистировал в ветеринарной клинике. С 2017 по 2019 годы принимал участие в Национальных Ветеринарных Конференциях. С 2019 года работал в ветеринарном центре «Феникс» г. Ногинск. ",
            photo = IMAGES[0]
        ))

        users.add(User(
            id = 2,
            name = "Петрова Ольга Владимировна",
            jobTitle = "ветеринар",
            experience =  "Опыт работы: С 2018 года работает в клинике для домашних животных. Проходила стажировку в лаборатории по диагностике заболеваний животных. Участвует в обучающих семинарах и мастер-классах по ветеринарии.",
            photo = IMAGES[1]
        ))

        users.add(User(
            id = 3,
            name = "Иванова Елена Сергеевна",
            jobTitle = "ветеринар",
            experience =  "Опыт работы: Начала работать в клинике для домашних животных с 2015 года. Специализируется на лечении кошек и собак. Прошла обучение в области кардиологии животных.",
            photo = IMAGES[2]
        ))

        users.add(User(
            id = 4,
            name = "Смирнов Алексей Петрович",
            jobTitle = "ветеринар",
            experience =  "Опыт работы: Более 7 лет опыта работы в ветеринарной клинике. Специализируется на лечении лошадей и скота. Участвует в конференциях и семинарах по ветеринарии.",
            photo = IMAGES[3]
        ))

        users.add(User(
            id = 5,
            name = "Кузнецова Мария Андреевна",
            jobTitle = "ветеринар",
            experience =  "Опыт работы: Работала в частной ветеринарной клинике с 2019 года. Прошла обучение по хирургии мелких домашних животных. Имеет сертификат по эндоскопии.",
            photo = IMAGES[4]
        ))

        val generatedUser: List<User> = users
    }

    fun getUsers():List<User>{
        return users
    }

    fun getUserById(id: Long): User? {
        return users.find { it.id == id }
    }

//    fun getAllUsers(): List<User> {
//        return databaseHelper.getAllUsers()
//    }


    companion object {
        private val IMAGES:MutableList<String> = mutableListOf(
            "https://images.unsplash.com/photo-1507003211169-0a1dd7228f2d?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8Mnx8ZmFjZXxlbnwwfHwwfHx8MA%3D%3D",
            "https://images.unsplash.com/photo-1554151228-14d9def656e4?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8M3x8ZmFjZXxlbnwwfHwwfHx8MA%3D%3D",
            "https://images.unsplash.com/photo-1500648767791-00dcc994a43e?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MTJ8fGZhY2V8ZW58MHx8MHx8fDA%3D",
            "https://images.unsplash.com/photo-1438761681033-6461ffad8d80?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MTF8fGZhY2V8ZW58MHx8MHx8fDA%3D",
            "https://plus.unsplash.com/premium_photo-1680020185326-45491267f8da?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MTd8fGZhY2V8ZW58MHx8MHx8fDA%3D"
        )
    }
}

