
const { Client, logger } = require("camunda-external-task-client-js");

// configuration for the Client:
//  - 'baseUrl': url to the Workflow Engine
//  - 'logger': utility to automatically log important events
const config = { baseUrl: "http://localhost:8080/engine-rest", use: logger, asyncResponseTimeout: 5000, workerId: "Justinian" };

// create a Client instance with custom configuration
const client = new Client(config);

// susbscribe to the topic: 'SendTweet'
client.subscribe("SendTweet", async function({ task, taskService }) {
  // Put your business logic
  console.log('Watering my strawberries - its great!');
  // complete the task
  await taskService.complete(task);
});