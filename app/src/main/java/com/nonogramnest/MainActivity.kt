package com.nonogramnest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.nonogramnest.ui.theme.NonogramNestTheme
import com.nonogramnest.model.achievement.AchievementViewModel
import com.nonogramnest.model.user.UserViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            NonogramNestTheme {
                Column(
                    modifier = Modifier.verticalScroll(rememberScrollState()),
                    verticalArrangement = Arrangement.spacedBy(30.dp),
                ) {
                    UsersList()
                    AchievementsList()
                }
            }
        }
    }
}

@Composable
fun UsersList() {
    val userViewModel = UserViewModel()
    userViewModel.getAllUsers()
    val usersList = userViewModel.userListLiveData?.observeAsState()?.value

    Column(
        modifier = Modifier.fillMaxWidth().padding(5.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp),

    ) {
        Text(text = "Użytkownicy", textAlign = TextAlign.Center, modifier = Modifier.fillMaxWidth().clip(RoundedCornerShape(5.dp)).background(
            Color.Gray).padding(10.dp))
        usersList?.forEach { user ->
            Row(
                horizontalArrangement = Arrangement.spacedBy(5.dp),
            ) {
                val userProps = listOf(user.id, user.username, user.email, user.role)

                userProps.forEach { userProp ->
                    Box(
                        modifier = Modifier.weight(0.25f)
                            .clip(RoundedCornerShape(5.dp))
                            .background(Color.LightGray)
                            .padding(vertical = 10.dp)
                    ) {
                        Text(text = userProp.toString(),
                            textAlign = TextAlign.Center,
                            modifier = Modifier.fillMaxWidth(),
                            overflow= TextOverflow.Ellipsis,
                            maxLines = 1
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun AchievementsList() {
    val achievementViewModel = AchievementViewModel()
    achievementViewModel.getAllAchievements()
    val usersList = achievementViewModel.achievementListLiveData?.observeAsState()?.value

    Column(
        modifier = Modifier.fillMaxWidth().padding(5.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        Text(text = "Osiągnięcia", textAlign = TextAlign.Center, modifier = Modifier.fillMaxWidth().clip(RoundedCornerShape(5.dp)).background(
            Color.Gray).padding(10.dp))
        usersList?.forEach { achievement ->
            Row(
                horizontalArrangement = Arrangement.spacedBy(5.dp),
            ) {
                val achievementProps = listOf(achievement.id, achievement.name, achievement.description)

                achievementProps.forEach { achievementProp ->
                    Box(
                        modifier = Modifier.weight(0.25f)
                            .clip(RoundedCornerShape(5.dp))
                            .background(Color.LightGray)
                            .padding(vertical = 10.dp)
                    ) {
                        Text(text = achievementProp.toString(),
                            textAlign = TextAlign.Center,
                            modifier = Modifier.fillMaxWidth(),
                            overflow= TextOverflow.Ellipsis,
                            maxLines = 1
                        )
                    }
                }
            }
        }
    }
}