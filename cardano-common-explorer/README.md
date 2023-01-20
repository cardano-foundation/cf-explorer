# Cardano Common Library
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
		<id>cardano-common-explorer</id>
		<repositories>
		  <repository>
			<id>central</id>
			<url>https://repo1.maven.org/maven2</url>
		  </repository>
		  <repository>
			<id>cardano-common-explorer</id>
			<url>https://maven.pkg.github.com/sotatek-dev/cardano-common-explorer</url>
			<snapshots>
			  <enabled>true</enabled>
			</snapshots>
		  </repository>
		</repositories>
	  </profile>
	</profiles>

	<servers>
	  <server>
		<id>cardano-common-explorer</id>
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
      <url>https://maven.pkg.github.com/sotatek-dev/cardano-common-explorer</url>
    </repository>
  </distributionManagement>
```

If you want to deploy package run:
```
mvn clean deploy
```

On the consumer side add dependency element to your project pom.xml file.
```
<dependency>
      <groupId>com.sotatek.cardano</groupId>
      <artifactId>cardano-common-explorer</artifactId>
      <version>1.0-SNAPSHOT</version>
</dependency>
```




