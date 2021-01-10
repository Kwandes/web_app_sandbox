# Project Setup
This file describes the setup process of the repository, with the commands and steps needed to successfully recreate it

## Workspace setup
Create a new workspace in the root folder of the repository
`npx create-nx-workspace@latest app-sandbox`

Type: Empty, NX Cloud enabled

## Semantic release

- install semantic-release dev dependency: `npm i -D semantic-release`

- package.json:

  - Add script `semantic-release: semantic-release`
  - Change version field to "0.0.0-development" - `"version": "0.0.0-development",`
  - Add `"private": true` property to prevent publishing to npm registry
  - Add or overwrite the repository field,

    ```json
    {
      ...,
      "repository": {
        "type": "git",
        "url": "https://github.com/Royserg/sturdy_test.git"
      },
    }
    ```

- Create `.releaserc.json` in root directory:

Replace placeholders in `repositoryUrl`

```json
{
  "branches": "master",
  "repositoryUrl": "https://github.com/[GITHUB_USERNAME]/[REPOSITORY_NAME]",
  "debug": "true",
  "plugins": [
    "@semantic-release/commit-analyzer",
    "@semantic-release/release-notes-generator",
    [
      "@semantic-release/npm",
      {
        "npmPublish": false
      }
    ],
    "@semantic-release/github",
    [
      "@semantic-release/changelog",
      {
        "changelogFile": "CHANGELOG.md"
      }
    ],
    [
      "@semantic-release/git",
      {
        "assets": ["package.json", "package-lock.json", "CHANGELOG.md"],
        "message": "chore(release): ${nextRelease.version} [skip ci]\n\n${nextRelease.notes}"
      }
    ]
  ]
}
```

last entry for `@semantic-release/git` specifies what assets should be updated:
updating versions in:

- `package.json`
- `package-lock.json`
  and updating general `CHANGELOG.md` file (it will be created if doesn't exist)
  [semantic-release/git](https://github.com/semantic-release/git) is going to make a commit with provided message.
  `[skip ci]` keyword will prevent triggering new unnecessary CI build.

semantic-release default plugins:

- @semantic-release/commit-analyzer
- @semantic-release/release-notes-generator
- @semantic-release/npm
- @semantic-release/github

### Install required external plugins:

```shell
npm install -D @semantic-release/git @semantic-release/changelog
```

- Add release workflow in `.github/workflows/semantic-release.yml`

```yml
# Create and update releases and program versions
name: Release
on:
  push:
    branches:
      - master
  workflow_dispatch:

jobs:
  release:
    name: Create a Release
    runs-on: ubuntu-latest
    steps:
      - name: Checkout
        uses: actions/checkout@v2
        with:
          fetch-depth: 0
          persist-credentials: false

      - name: Setup Node.js
        uses: actions/setup-node@v1
        with:
          node-version: 12

      - name: Install dependencies
        run: npm ci

      - name: Release
        env:
          GITHUB_TOKEN: ${{ secrets.GITHUB_TOKEN }}
        run: npx semantic-release
```

## git-cz and Commitizen

To follow [Angular commit message conventions](https://github.com/angular/angular.js/blob/master/DEVELOPERS.md#-git-commit-guidelines), install git-cz and Commitizen

[git-cz docs](https://github.com/streamich/git-cz)
I installed globally with with Commitizen as below

```shell
npm install -g commitizen git-cz
commitizen init git-cz --save-dev --save-exact
```
_If you install `commitizen` and `git-cz` locally, you will have to run `npx git cz` instead_

Then use below command to commit staged files:

```shell
git cz
```

And use of the the predefined types to describe your commit
![git-cz commit types](git-cz.png)

## In action:

semantic-release automatically determine the type of change depending on the commit messages. There are [3 types of commits](https://github.com/semantic-release/semantic-release#commit-message-format) that trigger version change

Below test commit messages with provided `git-cz` commit types.

- `perf` type triggers major release

![Major change release](perf_commit_type.jpg)

- `fix` and `feat` types trigger patch and minor releases

![patch and minor release](patch_and_minor_release.jpg)