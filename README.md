# Quarkus Backstage

[![Version](https://img.shields.io/maven-central/v/io.quarkiverse.backstage/quarkus-backstage?logo=apache-maven&style=flat-square)](https://central.sonatype.com/artifact/io.quarkiverse.backstage/quarkus-backstage-parent)

Generate Backstage Catalog Information as part of the Quarkus build or the Quarkus CLI.

## Features

- Generate the catalog-info.yaml for the Quarkus application
- Generate Backstage Template from an existing Quarkus application
- CLI interface (for entities and templates):
  - generate 
  - list
  - install
  - uninstall
- Orchestrate (configure & align) Quarkus extensions:
  - kubernetes
  - helm
  - argocd
- Dev Service and DevUI for Backstage

*Note*: To fully take advantage of the orchestration feature, backstage needs to be configured accordingly.

## Requirements

### For using the CLI / Client
- A running Bacsktage installation with a known token (see: [Service to Service authentication](https://backstage.io/docs/auth/service-to-service-auth#static-tokens))

### For Catalog Info Generation
To generate the catalog-info.yaml nothing special is required. The catalog is generated without requiring connection to the backstage backend.

### For Template Generation
To generate a backstage template, at build time, the following property is required:

```
quarkus.backstage.template.generation.enabled=true
```


## Building

To build the extension use the following command:

```shell
mvn clean install
```

## Usage

To get the backstage catalog-info.yaml generated, it is needed to add the `quarkus-backstage` extension to the project.

### Add extension to your project 

To add the extension to the project, manually edit the `pom.xml` or `build.gradle` file.

#### Manually editing the `pom.xml` file

```xml
<dependency>
    <groupId>io.quarkiverse.backstage</groupId>
    <artifactId>quarkus-backstage</artifactId>
    <version>999-SNAPSHOT</version>
</dependency>
```

#### Manually editing the `build.gradle` file

```groovy
dependencies {
    implementation 'io.quarkiverse.backstage:quarkus-backstage:999-SNAPSHOT'
}
```

After this step the catalog-info.yaml will be generated in the root of the project.

### Using the CLI

The project provides a companion CLI that can be used to install / uninstall and list the backstage entities.
The CLI can be added with the following command:

```shell
quarkus plug add io.quarkiverse.backstage:quarkus-backstage-cli:999-SNAPSHOT
```

#### Setting the Backstage backend token

To talk the backstage backend, the CLI needs to know:
- The URL to the backend
- The Token used by the backend for Service to Service communication

Both can be set either using environment:
- environment variables: `QUARKUS_BACKSTAGE_URL` and `QUARKUS_BACKSTAGE_TOKEN`
- application.properties: `quarkus.backstage.url` and `quarkus.backstage.token`


### Entities

#### Regenerating the entities:

To re-triggger the file generation:

```shell
quarkus backstage entities generate
```

#### Installing the application

To install generated entities:

```shell
quarkus backstage entities install
```
To uninstall:

```shell
quarkus backstage entities uninstall
```

#### Listing entities

To list all entitties installed

```shell
quarkus backstage entities list
```

### Templates

#### Generating a Backstage Template

The backstage extension is able to generate a backstage template from an existing Quarkus application.
The generated template will include a parameterized version of the project and a template definition.

##### Generated Template

###### Parameters
The following parameters are generated:
- `componentId`: The component id that will be used in the backstage catalog
- `groupId`: The group id of the project
- `artifactId`: The artifact id of the project
- `version`: The version of the project
- `description`: The description of the project
- `name`: The name of the project
- `package`: The base package of the project
###### Steps

- `render`: Render the project template.
- `publish`: Publish the generated code to github.
- `register`: Register the component in the backstage catalog.


#### Generating a Template using the CLI

To generate a backstage template from an existing Quarkus application:

```shell
quarkus backstage template generate
```

#### Generating a Backstage Template

To generate a backstage template from an existing Quarkus application:

```shell
quarkus backstage template generate
```

The command will generate a template under the `.backstage/templates` directory.
The template can then be manually imported to backstage.


#### Installing a Backstage Template

The generated template can be installed to backstage using the following command:

```shell
quarkus backstage template install
```

This requires the application to be added to SCM.
The command will commit the template related files to the `backstage` branch and push it to `origin`.
The branch name and remote name can be optionally configured using the following flags.

```shell
quarkus backstage template install --branch <branch> --remote <remote>
```

### Dev Service
To use the Backstage Dev Service, just add the extension to the project:

*Note:* Until, the project gets released, please add the extension as a maven dependency,
as the CLI will not be able to find the extension.

#### Add the extension in the pom.xml

```xml
<dependency>
    <groupId>io.quarkiverse.backstage</groupId>
    <artifactId>quarkus-backstage</artifactId>
    <version>999-SNAPSHOT</version>
</dependency>
```

#### Add the extension using the CLI

```shell
quarkus ext add quarkus-backstage
```

and then run:

```shell
quarkus dev
```

When the dev service starts, it will report the Backstage URL in the console.
Additionally, the Backstage Dev Service can be access from the Dev UI: `http://localhost:8080/q/dev-ui`

### Integrations

#### quarkus-jgit

The extension uses the `quarkus-jgit` extension to interact with git repositories.
Additionally, it uses the Dev Service provided by `quarkus-jgit` when id dev mode, so that interactions with git repositories
can be done without using the actual project repository. In other words it allows using Dev Services instead of the actual remote repository (e.g Github, Gitlab, etc).

The integration can be enabled using:

```
quarkus.jgit.devservices.enabled=true
```

When this property is used in dev mode, A container running Gitea will be created and an empty repository with the project name will be created, under the `quarkus` (user / organization).
The password for the quarkus user is also `quarkus`. See the `quarkus-jgit` documentation for more details. 
