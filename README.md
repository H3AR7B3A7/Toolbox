[![License](https://img.shields.io/badge/license-MIT-blue)](LICENSE.md)
![Issues](https://img.shields.io/github/issues/h3ar7b3a7/Toolbox)
![Pull Requests](https://img.shields.io/github/issues-pr-raw/h3ar7b3a7/Toolbox)

# Toolbox

A platform for all sorts of tooling.

## Documentation

- [Toolbox UI](toolbox-fe/README.md)
- [Toolbox Service](toolbox-be/README.md)

## Project Info

- [Work Board](https://github.com/users/H3AR7B3A7/projects/1/views/1)
- [Roadmap](Roadmap.md)
- [LICENSE](LICENSE.md)

## Development

### URI

- [UI](http://localhost:4200)
- [Service](http://localhost:8080)
- [DB Management](http://localhost:8081)

### Quick Setup

#### PowerShell

- Database & management: `./docker-setup.sh`
- Local projects:
    - Service: `./toolbox-be/gradlew -b toolbox-be/build.gradle bootRun`
    - UI: `yarn --cwd toolbox-fe` &  `yarn --cwd toolbox-fe start`

_These commands should be run from this directory._

[//]: # (TODO: Add spring & angular app to docker-compose)

## Contribution

Feel free to pick up a ticket and make a pull request.

_New ideas for features are always welcome too._

### Branches

#### Naming convention

`<type>/<number>-<optional description>`

Example:

`feature/1-SSO`

#### Types

- feature
- task
- doc

### Commits

#### Recommended emoji

- :sparkles: - New feature
- :bug: - Bugfix
- :ambulance: - Remove vulnerability
- :memo: - Documentation
- :microscope: - Test (configuration)
- :building_construction: Project structure
- :recycle: - Refactor
- :stethoscope: - GitHub Actions
- :see_no_evil: - Git Ignore