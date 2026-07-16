package com.example.routemate




import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.compose.ui.text.font.FontWeight

@Composable
fun RoleCard(

    title: String,

    description: String,

    icon: ImageVector,

    selected: Boolean,

    onClick: () -> Unit

) {

    Card(

        modifier = Modifier
            .fillMaxWidth()
            .clickable {

                onClick()

            }
            .border(

                width = if (selected) 2.dp else 1.dp,

                color = if (selected)
                    Color(0xFF1565C0)
                else
                    Color.LightGray,

                shape = RoundedCornerShape(16.dp)

            ),

        shape = RoundedCornerShape(16.dp)

    ) {

        Row(

            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp),

            verticalAlignment = Alignment.CenterVertically

        ) {

            Icon(

                imageVector = icon,

                contentDescription = null,

                tint = Color(0xFF1565C0),

                modifier = Modifier.size(40.dp)

            )

            Spacer(modifier = Modifier.width(16.dp))

            Column(

                modifier = Modifier.weight(1f)

            ) {

                Text(

                    text = title,

                    fontWeight = FontWeight.Bold

                )

                Text(

                    text = description,

                    color = Color.Gray

                )

            }

            RadioButton(

                selected = selected,

                onClick = onClick

            )

        }

    }

}