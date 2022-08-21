package ru.netology.nmedia.repository

import androidx.lifecycle.MutableLiveData
import ru.netology.nmedia.dto.Post
import androidx.lifecycle.LiveData

class PostRepositoryInMemoryImpl : PostRepository {
    override val data = MutableLiveData(
        listOf(
            Post(
                id = 3,
                author = "Нетология. Университет интернет-профессий будущего",
                content = "Привет, это новая Нетология! Когда-то Нетология начиналась с интенсивов по онлайн-маркетингу. Затем появились курсы по дизайну, разработке, аналитике и управлению. Мы растём сами и помогаем расти студентам: от новичков до уверенных профессионалов. Но самое важное остаётся с нами: мы верим, что в каждом уже есть сила, которая заставляет хотеть больше, целиться выше, бежать быстрее. Наша миссия — помочь встать на путь роста и начать цепочку перемен → http://netolo.gy/fyb",
                published = "21 мая в 18:36",
                like = 999,
                repost = 999,
                view = 999,
                likedByMe = false
            ),
            Post(
                id = 2,
                author = "Нетология. Университет интернет-профессий будущего",
                content = "Когда-то Нетология начиналась с интенсивов по онлайн-маркетингу.",
                published = "20 мая в 10:00",
                like = 99,
                repost = 99,
                view = 99,
                likedByMe = false
            ),
            Post(
                id = 1,
                author = "Нетология. Университет интернет-профессий будущего",
                content = "Затем появились курсы по дизайну, разработке, аналитике и управлению..",
                published = "19 мая в 9:00",
                like = 9,
                repost = 9,
                view = 9,
                likedByMe = false
        )
    )
    )
    private val posts
        get() = checkNotNull(data.value) {
            "Data value should not be null"
        }

    override fun share(postId: Long) {
        data.value = posts.map {
            if (it.id != postId) it
            else it.copy(
                repost = it.repost + 10
            )
        }

    }

    override fun like(postId: Long) {
        data.value = posts.map {
            if (it.id != postId) it
            else it.copy(
                likedByMe = !it.likedByMe,
                like = it.like + if (!it.likedByMe) 1 else -1
            )
        }
    }

}
