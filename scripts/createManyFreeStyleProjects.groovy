// Create many FreeStyleProjects

int num = 20;
Jenkins h = Jenkins.get();
for (int i = 0; i < num; i++) {
	h.createProject(FreeStyleProject, "test" + i.toString());
}
