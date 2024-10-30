package com.example.latihaninput

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview (showBackground = true )
@Composable
fun LatihanInput(modifier: Modifier = Modifier){
    var nama by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var noTelepon by remember { mutableStateOf("") }
    var alamat by remember { mutableStateOf("") }
    var memilihJK by remember { mutableStateOf("") }

    var namasv by remember { mutableStateOf("") }
    var emailsv by remember { mutableStateOf("") }
    var noTeleponsv by remember { mutableStateOf("") }
    var alamatsv by remember { mutableStateOf("") }
    var memilihJKsv by remember { mutableStateOf("") }

    val listJk = listOf("Laki-Laki", "Perempuan")

    Column (modifier = modifier
        .fillMaxSize()
        .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Text("Biodata", fontSize = 20.sp, fontWeight = FontWeight.Bold)

        Spacer(Modifier .padding(16.dp))
      TextField(
          modifier = Modifier .fillMaxWidth().padding(5.dp),
          value = nama,
          onValueChange = {nama = it},
          label = { Text("Nama")},
          placeholder = { Text("Masukan Nama Anda")
          }


      )
        Row (verticalAlignment = Alignment.CenterVertically){
            listJk.forEach { item ->
                Row (verticalAlignment = Alignment.CenterVertically){ RadioButton(
                    selected = memilihJK == item,
                    onClick = {
                        memilihJK = item
                    }
                )
                    Text(item)
                }
            }

        }
        TextField(
            modifier = Modifier .fillMaxWidth().padding(5.dp),
            value = email,
            onValueChange = {email = it},
            label = { Text("Email")},
            placeholder = { Text("Masukan Email Anda")}

        )

        TextField(
            modifier = Modifier .fillMaxWidth().padding(5.dp),
            value = noTelepon,
            onValueChange = {noTelepon = it},
            label = { Text("No Telepon")},
            placeholder = { Text("Masukan Nomor Telepon Anda")}

        )
        TextField(
            modifier = Modifier .fillMaxWidth().padding(5.dp),
            value = alamat,
            onValueChange = {alamat = it},
            label = { Text("Alamat")},
            placeholder = { Text("Masukan Alamat Anda")}

        )

        Button (onClick = {
            namasv = nama
            emailsv = email
            noTeleponsv = noTelepon
            alamatsv = alamat
            memilihJKsv = memilihJK

        }) {
            Text("Submit")
        }
        ElevatedCard(
            colors = CardDefaults.cardColors(containerColor = Color.LightGray),
            modifier = Modifier
            .fillMaxWidth()
            .background(color = Color.Blue)
        ){
            DetailSurat(judul = "nama", isinya = namasv)
            DetailSurat(judul = "email", isinya = emailsv)
            DetailSurat(judul = "NoTelepon", isinya = noTeleponsv)
            DetailSurat(judul = "alamat", isinya = alamatsv)
            DetailSurat(judul = "memilihJK", isinya = memilihJKsv)

        }

    }
}

@Composable
fun DetailSurat(
    judul: String, isinya: String
){
    Column(
        modifier = Modifier.fillMaxWidth().padding(8.dp),
    ){

        Row (
            modifier = Modifier.fillMaxWidth()
        ){
            Text(text = judul,
                modifier = Modifier.weight(0.8f))
            Text(text = ":",
                modifier = Modifier.weight(0.1f))
            Text(text = isinya,
                modifier = Modifier.weight(2f))
        }



    }
}
