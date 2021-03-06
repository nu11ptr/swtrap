# swtrap

SWT/RAP + JFreeChart - JVM *and* Native Image Demo

## Global

### Clean Build (JVM - All projects)

```shell
./gradlew
```

## SWT (Native Image)

### Update Tracing Agent Data

NOTE: This should be done after every major change or dependency addition

```shell
<graalvm_java_path> -agentlib:native-image-agent=config-output-dir=swt/src/main/resources/META-INF/native-image/ -jar swt/build/libs/swt-all.jar
```

### Build

```shell
export GRAALVM_HOME=<graalvm_folder>
./gradlew :swt:nativeBuild
```

### Run

```shell
./gradlew :swt:nativeRun
```

## SWT (JVM)

### Build

```shell
./gradlew :swt:build
```

### Run

```shell
./gradlew :swt:run
```

## RWT (Native Image)

### Update Tracing Agent Data

NOTE: This should be done after every major change or dependency addition

```shell
<graalvm_java_path> -agentlib:native-image-agent=config-output-dir=rwt/src/main/resources/META-INF/native-image/ -jar rwt/build/libs/rwt.jar
```

### Build

```shell
export GRAALVM_HOME=<graalvm_folder>
./gradlew :rwt:nativeBuild
```

### Run

```shell
./gradlew :rwt:nativeRun
```

## RWT (JVM)

### Build

```shell
./gradlew :rwt:build
```

### Run

NOTE: The application will be available at <http://localhost:8080/rwt>

```shell
./gradlew :rwt:bootRun
```
