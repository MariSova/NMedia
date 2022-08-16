package ru.netology.nmedia

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ru.netology.nmedia.databinding.ActivityMainBinding
import ru.netology.nmedia.dto.Post


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val post = Post (
            id = 1,
            author = "Нетология. Университет интернет-профессий будущего",
            content = "Привет, это новая Нетология! Когда-то Нетология начиналась с интенсивов по онлайн-маркетингу. Затем появились курсы по дизайну, разработке, аналитике и управлению. Мы растём сами и помогаем расти студентам: от новичков до уверенных профессионалов. Но самое важное остаётся с нами: мы верим, что в каждом уже есть сила, которая заставляет хотеть больше, целиться выше, бежать быстрее. Наша миссия — помочь встать на путь роста и начать цепочку перемен → http://netolo.gy/fyb",
            published = "21 мая в 18:36",
            likeCount = 999,
            shareCount = 999,
            likedByMe = false
        )
        with(binding) {
            authorName.text = post.author
            content.text = post.content
            date.text = post.published
            likeCount.text = post.likeCount.toString()
            repostCount.text = post.shareCount.toString()

            if (post.likedByMe) {
                like?.setImageResource(R.drawable.ic_like_post_24dp)
            }

            like?.setOnClickListener {
                post.likedByMe = !post.likedByMe
                like.setImageResource(
                    if (post.likedByMe) R.drawable.ic_like_post_24dp
                    else R.drawable.ic_liked_24
                )

                val counter = post.likeCount + 1
                if (post.likedByMe) likeCount.text = Format().reductionInNumbers(counter) else likeCount.text =
                    Format().reductionInNumbers(post.likeCount)
            }

            repost.setOnClickListener {
                val counter = post.shareCount++
                repostCount.text = Format().reductionInNumbers(counter)
            }

        }

    }
}
//        binding.render(post)
//        binding.like.setOnClickListener {
//            post.likedByMe = !post.likedByMe
//                binding.like.setImageResource(getLikeIconResId(post.likedByMe))
//        }
 //   }

//    private fun ActivityMainBinding.render(post: Post) {
//        authorName.text = post.author
//        content.text = post.content
//        date.text = post.published
//        like.setImageResource(getLikeIconResId(post.likedByMe))
//    }
//    @DrawableRes
//    private fun getLikeIconResId(liked: Boolean) =
//        if (liked) R.drawable.ic_liked_24 else R.drawable.ic_like_post_24dp



//}