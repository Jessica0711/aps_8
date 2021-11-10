import { default as React, useState } from 'react';
import { Image, KeyboardAvoidingView, StyleSheet, Text, TextInput, TouchableOpacity, View } from 'react-native';

export default function App() {
  const [previsao, setPrevisao] = useState([{ avisos: [] }, {}, {}, {}]);
  const [nomeCidade, setNomeCidade] = useState('');
  const [avisos, setAvisos] = useState([]);
  return (
    <KeyboardAvoidingView style={styles.background}>
      <View style={styles.containerLogo}>
        <Image
          source={require('./assets/logo.png')}
        />
      </View>

      <View style={styles.container}>
        <TextInput

          style={styles.input}
          placeholder="Insira a cidade "
          autoCorrect={false}
          onChangeText={(text) => setNomeCidade(text)}
        />

        <TouchableOpacity style={styles.btnProcurar}
          onPress={() => {
            const API = `http://localhost:8080//consultaprevisoes/?nomeCidade=${nomeCidade}`
            try {
              fetch(API).then(data => {
                data.json().then(res => setPrevisao(res));
              });
            } catch (error) {
              console.log(error);
            }
          }}>

          <Text style={styles.txtProcurar}>Buscar</Text>

        </TouchableOpacity>

        <Text style={styles.txtData}>
          Previsão de hoje
        </Text>

      </View>

      <View style={styles.container2}>
        <Text style={styles.txtMax}>
          Máx:
        </Text>

        <Text style={styles.txtTempMax}>
          {previsao[0]?.maxima}
        </Text>

        <Text style={styles.txtMin}>
          Min:
        </Text>

        <Text style={styles.txtTempMin}>
          {previsao[0].minima}
        </Text>

        <Text style={styles.txtUv}>
          UV:
        </Text>

        <Text style={styles.txtRaiosUV}>
          {previsao[0].iuv}
        </Text>

      </View>

      <View style={styles.container3}>

        <Text style={styles.txtData2}>
          {new Date(previsao[1].dia).toLocaleDateString()}
        </Text>

        <Text style={styles.txtMax2}>
          - Máx:
        </Text>

        <Text style={styles.txtTempMax2}>
          {previsao[1].maxima}
        </Text>

        <Text style={styles.txtMin2}>
          Min:
        </Text>

        <Text style={styles.txtTempMin2}>
          {previsao[1].minima}
        </Text>

        <Text style={styles.txtUv2}>
          UV:
        </Text>

        <Text style={styles.txtRaiosUV2}>
          {previsao[1].iuv}
        </Text>

      </View>

      <View style={styles.container4}>

        <Text style={styles.txtData3}>
          {new Date(previsao[2].dia).toLocaleDateString()}
        </Text>

        <Text style={styles.txtMax3}>
          - Máx:
        </Text>

        <Text style={styles.txtTempMax3}>
          {previsao[2].maxima}
        </Text>

        <Text style={styles.txtMin3}>
          Min:
        </Text>

        <Text style={styles.txtTempMin3}>
          {previsao[2].minima}
        </Text>

        <Text style={styles.txtUv3}>
          UV:
        </Text>

        <Text style={styles.txtRaiosUV3}>
          {previsao[2].iuv}
        </Text>
      </View>

      <View style={styles.container5}>

        <Text style={styles.txtData4}>
          {new Date(previsao[3].dia).toLocaleDateString()}
        </Text>

        <Text style={styles.txtMax4}>
          - Máx:
        </Text>

        <Text style={styles.txtTempMax4}>
          {previsao[3].maxima}
        </Text>

        <Text style={styles.txtMin4}>
          Min:
        </Text>

        <Text style={styles.txtTempMin4}>
          {previsao[3].minima}
        </Text>

        <Text style={styles.txtUv4}>
          UV:
        </Text>

        <Text style={styles.txtRaiosUV4}>
          {previsao[3].iuv}
        </Text>
      </View>
      <View style={styles.container6}>
          <Text style={styles.txtAlerta}>
            {previsao[0].avisos.map(aviso => {
              return aviso.mensagem + '. ';
              })}
          </Text>
        </View>
      
    </KeyboardAvoidingView>
  );
}

//Criação do style
const styles = StyleSheet.create({
  background: {
    flex: 1,
    backgroundColor: '#0583CB',
    alignItems: 'center',
    justifyContent: 'center',
  },

  //CSS do container da logo 
  containerLogo: {
    justifyContent: 'center',
    marginTop: 10,
  },

  //CSS do primeiro container
  container: {
    alignItems: 'center',
    justifyContent: 'center',
    width: '90%',
    margin: 10,
  },

  input: {
    backgroundColor: '#FFF',
    width: '90%',
    marginBottom: 15,
    color: '#222',
    fontSize: 17,
    borderRadius: 7,
    padding: 10,
  },
  btnProcurar: {
    backgroundColor: '#ffcc21',
    width: '90%',
    height: 45,
    borderRadius: 7,
    alignItems: 'center',
    justifyContent: 'center',
  },
  txtProcurar: {
    fontSize: 18,
  },

  txtData: {
    fontSize: 16,
    alignItems: 'center',
    justifyContent: 'center',
    color: '#FFF',
    margin: 20,
    fontWeight: "bold",
    marginTop: 50,
  },

  //CSS do segundo container 

  container2: {
    flexDirection: 'row',
    justifyContent: 'center',
    width: '90%',
    marginBottom: 15,
  },

  //Temperatura Máxima - 1

  txtMax: {
    fontSize: 20,
    alignItems: 'center',
    justifyContent: 'center',
    color: '#353839',
    fontWeight: "bold",
    paddingRight: 5,
  },

  txtTempMax: {
    fontSize: 20,
    alignItems: 'center',
    justifyContent: 'center',
    color: '#FFF',
    fontWeight: "bold",
    paddingRight: 10,
  },

  //Temperatura Minima - 1 
  txtMin: {
    fontSize: 20,
    alignItems: 'center',
    justifyContent: 'center',
    color: '#353839',
    fontWeight: "bold",
    paddingRight: 5,
  },

  txtTempMin: {
    fontSize: 20,
    alignItems: 'center',
    justifyContent: 'center',
    color: '#FFF',
    fontWeight: "bold",
    paddingRight: 10,
  },

  //Raios UV
  txtUv: {
    fontSize: 20,
    alignItems: 'center',
    justifyContent: 'center',
    color: '#353839',
    fontWeight: "bold",
    paddingRight: 5,
  },

  txtRaiosUV: {
    fontSize: 20,
    alignItems: 'center',
    justifyContent: 'center',
    color: '#FFF',
    fontWeight: "bold",
    paddingRight: 10,
  },

  //CSS do terceiro container 

  container3: {
    flexDirection: 'row',
    justifyContent: 'center',
    width: '90%',
    marginBottom: 10,
  },

  //Temperatura Máxima - 2

  txtMax2: {
    fontSize: 17,
    alignItems: 'center',
    justifyContent: 'center',
    color: '#353839',
    fontWeight: "bold",
    paddingRight: 5,
  },

  txtTempMax2: {
    fontSize: 17,
    alignItems: 'center',
    justifyContent: 'center',
    color: '#FFF',
    fontWeight: "bold",
    paddingRight: 10,
  },

  //Temperatura Minima - 2
  txtMin2: {
    fontSize: 17,
    alignItems: 'center',
    justifyContent: 'center',
    color: '#353839',
    fontWeight: "bold",
    paddingRight: 5,
  },

  txtTempMin2: {
    fontSize: 17,
    alignItems: 'center',
    justifyContent: 'center',
    color: '#FFF',
    fontWeight: "bold",
    paddingRight: 10,
  },

  //Raios UV - 2
  txtUv2: {
    fontSize: 17,
    alignItems: 'center',
    justifyContent: 'center',
    color: '#353839',
    fontWeight: "bold",
    paddingRight: 5,
  },

  txtRaiosUV2: {
    fontSize: 17,
    alignItems: 'center',
    justifyContent: 'center',
    color: '#FFF',
    fontWeight: "bold",
    paddingRight: 10,
  },

  //container 4
  container4: {
    flexDirection: 'row',
    //flex: 1,
    //alignItems: 'flex-start',
    justifyContent: 'center',
    width: '90%',
    marginBottom: 10,
  },

  //Temperatura Máxima - 3

  txtMax3: {
    fontSize: 17,
    alignItems: 'center',
    justifyContent: 'center',
    color: '#353839',
    fontWeight: "bold",
    paddingRight: 5,
  },

  txtTempMax3: {
    fontSize: 17,
    alignItems: 'center',
    justifyContent: 'center',
    color: '#FFF',
    fontWeight: "bold",
    paddingRight: 10,
  },

  //Temperatura Minima - 3
  txtMin3: {
    fontSize: 17,
    alignItems: 'center',
    justifyContent: 'center',
    color: '#353839',
    fontWeight: "bold",
    paddingRight: 5,
  },

  txtTempMin3: {
    fontSize: 17,
    alignItems: 'center',
    justifyContent: 'center',
    color: '#FFF',
    fontWeight: "bold",
    paddingRight: 10,
  },

  //Raios UV - 3
  txtUv3: {
    fontSize: 17,
    alignItems: 'center',
    justifyContent: 'center',
    color: '#353839',
    fontWeight: "bold",
    paddingRight: 5,
  },

  txtRaiosUV3: {
    fontSize: 17,
    alignItems: 'center',
    justifyContent: 'center',
    color: '#FFF',
    fontWeight: "bold",
    paddingRight: 10,
  },

  //container 5
  container5: {
    flexDirection: 'row',
    //flex: 1,
    //alignItems: 'flex-start',
    justifyContent: 'center',
    width: '90%',
    marginBottom: 30,
  },

  //Temperatura Máxima - 4

  txtMax4: {
    fontSize: 17,
    alignItems: 'center',
    justifyContent: 'center',
    color: '#353839',
    fontWeight: "bold",
    paddingRight: 5,
  },

  txtTempMax4: {
    fontSize: 17,
    alignItems: 'center',
    justifyContent: 'center',
    color: '#FFF',
    fontWeight: "bold",
    paddingRight: 10,
  },

  //Temperatura Minima - 4
  txtMin4: {
    fontSize: 17,
    alignItems: 'center',
    justifyContent: 'center',
    color: '#353839',
    fontWeight: "bold",
    paddingRight: 5,
  },

  txtTempMin4: {
    fontSize: 17,
    alignItems: 'center',
    justifyContent: 'center',
    color: '#FFF',
    fontWeight: "bold",
    paddingRight: 10,
  },

  //Raios UV - 4
  txtUv4: {
    fontSize: 17,
    alignItems: 'center',
    justifyContent: 'center',
    color: '#353839',
    fontWeight: "bold",
    paddingRight: 5,
  },

  txtRaiosUV4: {
    fontSize: 17,
    alignItems: 'center',
    justifyContent: 'center',
    color: '#FFF',
    fontWeight: "bold",
    paddingRight: 10,
  },

  // CSS Datas

  txtData2: {
    fontSize: 15,
    alignItems: 'center',
    justifyContent: 'center',
    color: '#ffcc21',
    fontWeight: "bold",
  },

  txtData3: {
    fontSize: 15,
    alignItems: 'center',
    justifyContent: 'center',
    color: '#ffcc21',
    fontWeight: "bold",
  },

  txtData4: {
    fontSize: 15,
    alignItems: 'center',
    justifyContent: 'center',
    color: '#ffcc21',
    fontWeight: "bold",
  },

  //CSS CONTAINER 6

  container6: {

    //flexDirection: 'row',
    flex: 1,
    alignItems: 'center',
    justifyContent: 'center',
    width: '100%',
    backgroundColor: '#ffcc21',
    borderRadius: 7,
    marginTop: 15,
  },

  //CSS Alerta

  txtAlerta: {
    fontSize: 15,
    alignItems: 'center',
    justifyContent: 'center',
    color: '#000',
    padding: 10,
    textAlign: 'center',

  },

});
