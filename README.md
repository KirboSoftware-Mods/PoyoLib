# Poyo Lib

A utility library for all KirboSoftware mods

## Using it in your project
add the repository
```groovy
repositories {
    //...
    maven {
        name 'KirboSoftware'
        url 'https://repsy.io/mvn/kirbosoftware/releases'
    }
    //...
}
```
then add the project like so
```groovy
dependencies {
    //...
    modImplementation "com.kirbosoftware:poyolib:$version"
    //...
}
```
replace `$version` with the version of poyo lib you want to use.

## License

Poyo Lib is under the MIT, please check out the license!