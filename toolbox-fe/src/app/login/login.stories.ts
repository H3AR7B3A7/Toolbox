import { Meta, moduleMetadata, Story } from '@storybook/angular';
import { MatButtonModule } from '@angular/material/button';

import {LoginComponent} from "@app/login/login.component";

export default {
  component: LoginComponent,
  title: 'Login Page/OAuth Options',
  excludeStories: /.*Data$/,
  decorators: [
    moduleMetadata({
      imports: [MatButtonModule]
    })
  ]
} as Meta;

const Template: Story = (args) => ({
  props: {
    ...args
  }
});

export const Default = Template.bind({});
