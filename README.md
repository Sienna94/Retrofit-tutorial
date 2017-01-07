# Retrofit-tutorial

This is a sample project to show how to use Retrofit Libaray in your Android App.

## Used Libaray (사용한 라이브러리)

- [Retrofit](https://square.github.io/retrofit)
- [Butterknife](http://jakewharton.github.io/butterknife)
- [JSONPlaceholder](http://jsonplaceholder.typicode.com)

```groovy
dependencies {
    compile 'com.squareup:otto:1.3.8'
    compile 'com.squareup.retrofit2:retrofit:2.1.0'
    compile 'com.squareup.retrofit2:converter-gson:2.1.0'

  compile 'com.jakewharton:butterknife:8.4.0'
  annotationProcessor 'com.jakewharton:butterknife-compiler:8.4.0'
}
```

## Detail

1. MainActivity : just test Acitivty
2. RetroClient : create Retrofit instance and apiService. then networking 
3. RetroCallback : received data and pass UI thread
4. RetroBaseApiService : The api to access JSONPlaceholder
5. RequestPut : request form in put method
6. ResponseGet : received form in get method

NOTE
- Add Internet permission in AndroidManifest.xml
```
<uses-permission android:name="android.permission.INTERNET"/>
```

## Output
![Swift GIF Image](http://i.imgur.com/y6jHCsX.gif)
