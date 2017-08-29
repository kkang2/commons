package main

import (
	"skt/snap-plugin-collector-smartctl-skt/smartctl"
	"github.com/intelsdi-x/snap-plugin-lib-go/v1/plugin"
)

const (
	pluginName = "smartctl" // Name of plugin
	pluginVersion = 1 // Version of plugin
)

func main() {
	plugin.StartCollector(smartctl.New(), pluginName, pluginVersion)
}