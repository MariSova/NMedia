package ru.netology.nmedia.repository
import androidx.lifecycle.MutableLiveData
import ru.netology.nmedia.dto.Post

class PostRepositoryInMemoryImpl: PostRepository {
    override var data = MutableLiveData(
        Post(
            id = 1,
            author = "Нетология. Университет интернет-профессий будущего",
            content = "Привет, это новая Нетология! Когда-то Нетология начиналась с интенсивов по онлайн-маркетингу. Затем появились курсы по дизайну, разработке, аналитике и управлению. Мы растём сами и помогаем расти студентам: от новичков до уверенных профессионалов. Но самое важное остаётся с нами: мы верим, что в каждом уже есть сила, которая заставляет хотеть больше, целиться выше, бежать быстрее. Наша миссия — помочь встать на путь роста и начать цепочку перемен → http://netolo.gy/fyb",
            published = "21 мая в 18:36",
            like = 999,
            repost = 999,
            view = 999,
            likedByMe = false
        )
    )

    override fun like() {
        val post = checkNotNull(data.value) {
            "Data value should not be null"
        }
        data.value = post.copy(
            likedByMe = !post.likedByMe,
            like = if (!post.likedByMe) post.like + 1 else post.like - 1
        )

    }

    override fun share() {
        val post = checkNotNull(data.value) {
            "Data value should not be null"
        }
        data.value = post.copy(repost = post.repost + 1)
    }

    override fun view() {
        val post = checkNotNull(data.value) {
            "Data value should not be null"
        }
        data.value = post.copy(view = post.view + 1)
    }
}
