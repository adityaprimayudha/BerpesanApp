package com.dicoding.berpesanapp.ui.screen.post

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.dicoding.berpesanapp.data.di.Injection
import com.dicoding.berpesanapp.data.di.ViewModelFactory
import com.dicoding.berpesanapp.data.model.Post
import com.dicoding.berpesanapp.ui.common.UiState
import com.dicoding.berpesanapp.ui.components.PostItem

@Composable
fun PostScreen(
    modifier: Modifier = Modifier,
    viewModel: PostViewModel = viewModel(
        factory = ViewModelFactory(Injection.provideRepository())
    )
) {
    val uiState by viewModel.state.collectAsState(initial = UiState.Loading)
    
    when(uiState) {
        is UiState.Loading -> {
            viewModel.getAllPosts()
        }
        is UiState.Success -> {
            val posts = (uiState as UiState.Success<List<Post>>).data
            PostContent(
                modifier = modifier,
                posts = posts
            ) { post ->
                viewModel.addPost(post)
            }
        }
        is UiState.Error -> {
            Log.d("Posts error", (uiState as UiState.Error).message)
        }
    }
}

@Composable
fun PostContent(
    modifier: Modifier = Modifier,
    posts: List<Post>,
    addToPost: (Post) -> Unit
) {
    var title by remember { mutableStateOf("") }
    var content by remember { mutableStateOf("") }

    Column(modifier = modifier) {
        OutlinedTextField(
            value = title,
            onValueChange = {
                title = it
            },
            label = {
                Text("Title")
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
        )
        OutlinedTextField(
            value = content,
            onValueChange = {
                content = it
            },
            label = {
                Text("Content")
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
        )
        Button(
            onClick = {
                val post = Post(title = title, content = content)
                addToPost(post)
                title = ""
                content = ""
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 8.dp),
        ) {
            Text("Post")
        }

        LazyColumn {
            items(posts, key = {it.id} ) { data ->
                PostItem(
                    date = "",
                    title = data.title,
                    content = data.content,
                    name = "",
                )
            }
        }

    }
}

@Preview(showBackground = true)
@Composable
private fun PostScreenPreview() {
    PostScreen()
}