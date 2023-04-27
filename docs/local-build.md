## Build from source on a local machine

There are three main repos in Ledger Sync project:
1. [Ledger Crawler](https://github.com/cardano-foundation/cf-ledger-crawler.git)
2. [Ledger Consumer](https://github.com/cardano-foundation/cf-ledger-consumer)
3. [Explorer Api](https://github.com/cardano-foundation/cf-explorer-api)

### Prerequisites
- Java 11
- Maven (https://maven.apache.org/download.cgi)

### Dependencies
**cf-ledger-consumer** depends on the following projects:
- [cf-java-cardano-common](https://github.com/cardano-foundation/cf-java-cardano-common.git)
- [cf-java-cardano-common-explorer](https://github.com/cardano-foundation/cf-java-cardano-common-explorer.git)

**cf-ledger-crawler** depends on the following projects:
- [cf-java-cardano-common](https://github.com/cardano-foundation/cf-java-cardano-common.git)

**cf-explorer-api** depends on the following projects:
- [cf-java-cardano-common](https://github.com/cardano-foundation/cf-java-cardano-common.git)
- [cf-java-cardano-common-explorer](https://github.com/cardano-foundation/cf-java-cardano-common-explorer.git)
- [cf-java-cardano-common-api](https://github.com/cardano-foundation/cf-java-cardano-common-api)

### Build Common Libraries

#### Build cf-java-cardano-common

1. Clone the repo

```shell
git clone git@github.com:cardano-foundation/cf-java-cardano-common.git
```

**Note:** Open pom.xml and make sure the current version is same as version used in cf-ledger-consumer's pom.xml

2. Build and deploy cf-java-cardano-common to your local maven repository.

```shell
cd cf-java-cardano-common
mvn clean install
```

#### Build cf-java-cardano-common-explorer

1. Clone the repo

```shell
git clone git@github.com:cardano-foundation/cf-java-cardano-common-explorer.git
```

**Note:** Open pom.xml and make sure the current version is same as version used in cf-ledger-consumer's pom.xml

2. Build and deploy cf-java-cardano-common-explorer to your local maven repository.

```shell
cd cf-java-cardano-common-explorer
mvn clean install
```

#### Build cf-java-cardano-common-api
1. Clone the repo

```shell
git clone git@github.com:cardano-foundation/cf-java-cardano-common-api.git
```

**Note:** Open pom.xml and make sure the current version is same as version used in cf-explorer-api's pom.xml

2. Build and deploy cf-java-cardano-common-api to your local maven repository.

```shell
cd cf-java-cardano-common-api
mvn clean install
```

### Build Ledger Consumer
Now that you have built and deployed cf-java-cardano-common and cf-java-cardano-common-explorer to your local maven repository, you can build cf-ledger-consumer.

1. Clone the repo

```shell
git clone git@github.com:cardano-foundation/cf-ledger-consumer.git
```

**Note:** Open pom.xml and verify cardano-common and cardano-common-explorer versions in pom.xml are same as the versions 
in the previous steps.

2. Build cf-ledger-consumer

```shell
cd cf-ledger-consumer
mvn clean package
```

### Build Ledger Crawler 
Now that you have built and deployed cf-java-cardano-common to your local maven repository, you can build cf-ledger-crawler.

1. Clone the repo

```shell
git clone git@github.com:cardano-foundation/cf-ledger-crawler.git
```

**Note:** Open pom.xml and verify cardano-common version in pom.xml is same as the version in the previous steps.

2. Build cf-ledger-crawler

```shell
cd cf-ledger-crawler
mvn clean package -DskipTests
```

### Build Explorer Api
Now that you have built and deployed cf-java-cardano-common, cf-java-common-explorer and cf-java-common-api to your local maven repository, you can build cf-explorer-api.

1. Clone the repo

```shell
git clone git@github.com:cardano-foundation/cf-explorer-api.git
```

**Note:** Open pom.xml and verify cardano-common-* versions in pom.xml are same as the versions in the previous steps.

2. Build cf-explorer-api

```shell
cd cf-explorer-api
mvn clean package -DskipTests
```
