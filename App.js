import { EvilIcons } from '@expo/vector-icons';
import { StatusBar } from 'expo-status-bar';
import React, { useState } from 'react';
import { StyleSheet, Text, TextInput, View } from 'react-native';

const express = require('express')
const cors = require('cors')
const app = express()
 
app.use(cors())

export default function App() {
  const [cityName, setCityName] = useState('');
  return (
    <View style={styles.container}>
      <Text>Hello Word</Text>
      <StatusBar style="auto" />
      <TextInput
        placeholder='Digite o nome da cidade'
        value={cityName}
        onChangeText={(text) => setCityName(text)}
      />
      <EvilIcons name="search" size={28} color="black" onPress={() => {
        const API = `http://localhost:8080//consultaprevisoes/?nomeCidade=${cityName}`
        try {
          const response = fetch(API);
          if (response.status == 200) {
            const data = response.json();
            console.log(data);
          } else {
          }
        } catch (error) {
          console.log(error);
        }
      }} />
    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: '#fff',
    alignItems: 'center',
    justifyContent: 'center',
  },
});
