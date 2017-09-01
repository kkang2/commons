package main

import (
	"skt/snap-plugin-collector-sysinfo-skt/sysinfo"
	"github.com/intelsdi-x/snap-plugin-lib-go/v1/plugin"
)

const (
	pluginName = "sysinfo" // Name of plugin
	pluginVersion = 1 // Version of plugin
)

func main() {
	plugin.StartCollector(sysinfo.New(), pluginName, pluginVersion)
}