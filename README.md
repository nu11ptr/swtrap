# swtrap

SWT / RAP Demo

## SWT

### Build (JVM)

```shell
./gradlew :swt:shadowJar
```

### Build (Native Image)

```shell
./gradlew :swt:nativeBuild
```

### Run (JVM)

```shell
./gradlew :swt:run
```

### Run (Native Image)

NOTE: This is not currently working

```shell
./gradlew :swt:nativeRun
```

## RWT

### Run (JVM)

NOTE: The application will be available at <http://localhost:8080/rwt>

```shell
./gradlew :rwt:bootRun
```
