package com.example.routemate



import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp

@Composable
fun ProfileTextField(

    value: String,

    onValueChange: (String) -> Unit,

    label: String,

    icon: ImageVector

) {

    OutlinedTextField(

        value = value,

        onValueChange = onValueChange,

        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),

        label = {
            Text(label)
        },

        leadingIcon = {
            Icon(icon, null)
        },

        shape = RoundedCornerShape(16.dp)

    )

}