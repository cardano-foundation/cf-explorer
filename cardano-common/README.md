# Cardano Common Library

### Reference Documentation
| Era | CDDL |
|-----|------|
|Babbage|[CDDL](https://github.com/input-output-hk/cardano-ledger/blob/master/eras/babbage/test-suite/cddl-files/babbage.cddl)
|Shelley|[CDDL](https://github.com/input-output-hk/cardano-ledger/tree/master/eras/shelley/test-suite/cddl-files)
|Byron|[CDDL](https://github.com/input-output-hk/cardano-ledger/blob/master/eras/byron/cddl-spec/byron.cddl)
|Allegra, Mary|[CDDL](https://github.com/input-output-hk/cardano-ledger/blob/master/eras/shelley-ma/test-suite/cddl-files/shelley-ma.cddl)
|Alonzo|[CDDL](https://github.com/input-output-hk/cardano-ledger/blob/master/eras/alonzo/test-suite/cddl-files/alonzo.cddl)

### Authenticating To GitHub Packages

You need to create access token to create, publish etc with different scope depending on your needs.

To authenticate to gitHub Packages registry within a GitHub Actions workflow, you can use:

* GITHUB_TOKEN to publish packages associated with the workflow repository.
* A personal access token (classic) with packages:read to install packages, packages:write to deploy packages.

Create file settings.xml in your ~/.m2

```
<settings xmlns="http://maven.apache.org/SETTINGS/1.0.0"
xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
xsi:schemaLocation="http://maven.apache.org/SETTINGS/1.0.0
				  http://maven.apache.org/xsd/settings-1.0.0.xsd">
	<activeProfiles>
	  <activeProfile>github</activeProfile>
	</activeProfiles>

	<profiles>
	  <profile>
		<id>github</id>
		<repositories>
		  <repository>
			<id>central</id>
			<url>https://repo1.maven.org/maven2</url>
		  </repository>
		  <repository>
			<id>${github}</id>
			<url>https://maven.pkg.github.com/{onwer}/{repository-name}</url>
			<snapshots>
			  <enabled>true</enabled>
			</snapshots>
		  </repository>
		</repositories>
	  </profile>
	</profiles>

	<servers>
	  <server>
		<id>${github}</id>
		<username>${username}</username>
		<password>${token}</password>
	  </server>
	</servers>
</settings>
```

In pom.xml
```
  <distributionManagement>
    <repository>
      <id>${github}</id>
      <name>GitHub sotatek-tiendo Apache Maven Packages</name>
      <url>https://maven.pkg.github.com/{onwer}/{repository-name}</url>
    </repository>
  </distributionManagement>
```

If you want to deploy package run:
```
mvn clean deploy
```

On the consumer side add dependencie element to your project pom.xml file.
```
<dependency>
      <groupId>com.sotatek.cardano</groupId>
      <artifactId>cardano-common</artifactId>
      <version>1.0-SNAPSHOT</version>
</dependency>
```




