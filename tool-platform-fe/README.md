# ToolPlatform

## Commands to Run & Manage App

```
yarn start - Start the application
yarn build - Output a production ready application in the dist folder
yarn test - Start Jest tests
yarn storybook - Run storybook on port 6006
yarn build-storybook - Output a static Storybook in the storybook-static directory
yarn test-storybook - Run storybook tests
yarn lint - Run linting using ES-Lint
yarn format - Format files using Prettier
yarn e2e - Run end-to-end tests using Cypress
yarn cypress:open - Open Cypress
yarn cypress:run - Run Cypress
```

## Commands Used to Build Project

### Scaffolding

```
ng n tool-platform --routing --style scss
ng g m core
ng g m shared
ng g c home
ng g c core/nav-bar
```

### Material

> ng add @angular/material

### Storybook

> npx storybook init

> yarn add -D @storybook/addon-a11y @storybook/test-runner

### Jest

> ng add @briebug/jest

> yarn add -D jest jest-preset-angular @types/jest @angular-builders/jest

### Remove Karma

> yarn remove karma karma-chrome-launcher karma-coverage-istanbul-reporter karma-jasmine karma-jasmine-html-reporter

### ES Lint & Prettier

> ng add @angular-eslint/schematics

> yarn add -D eslint-plugin-unused-imports prettier eslint-plugin-prettier eslint-config-prettier

### Cypress

> ng add @cypress/schematic
