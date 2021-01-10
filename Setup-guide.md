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